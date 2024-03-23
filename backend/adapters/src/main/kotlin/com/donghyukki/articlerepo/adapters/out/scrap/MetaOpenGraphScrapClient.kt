package com.donghyukki.articlerepo.adapters.out.scrap

import com.donghyukki.articlerepo.core.domain.article.model.ScrappedData
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import kotlinx.coroutines.reactive.awaitSingle
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.client.WebClient
import org.springframework.web.util.UriComponentsBuilder

@Component
class MetaOpenGraphScrapClient(
    @Value("\${meta.token}") private val token: String
) {
    suspend fun scrap(url: String): ScrappedData {
        val client = WebClient.create()
        val uri = UriComponentsBuilder.fromHttpUrl("https://graph.facebook.com")
            .queryParam("scrap", true)
            .queryParam("id", url)
            .build()
            .toUri()

        val response = client.post().uri(uri)
            .headers { it.setBearerAuth(token) }
            .exchangeToMono {
                it.bodyToMono(OpenGraphResponse::class.java)
            }.awaitSingle()

        return ScrappedData(
            title = response.title,
            description = response.description,
            imageUrl = response.image.first().url
        )
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    data class OpenGraphResponse(
        val title: String,
        val image: List<ImageUrl>,
        val description: String
    ) {
        data class ImageUrl(
            val url: String
        )
    }
}
