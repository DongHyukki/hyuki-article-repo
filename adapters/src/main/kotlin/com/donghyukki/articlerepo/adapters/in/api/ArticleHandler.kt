package com.donghyukki.articlerepo.adapters.`in`.api

import com.donghyukki.articlerepo.adapters.`in`.api.dto.ArticleRequests
import com.donghyukki.articlerepo.core.port.`in`.ArticleService
import kotlinx.coroutines.reactor.awaitSingle
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.bodyToMono
import org.springframework.web.reactive.function.server.bodyValueAndAwait

@Component
class ArticleHandler(
    private val articleService: ArticleService
) {

    suspend fun saveArticle(serverRequest: ServerRequest): ServerResponse {
        val request = serverRequest
            .bodyToMono<ArticleRequests.SaveRequest>()
            .awaitSingle()

        val savedArticle = articleService.saveArticle(request.toModel())
        // TODO: CONVERT TO UI MODEL
        return ServerResponse.ok().bodyValueAndAwait(savedArticle)
    }
}
