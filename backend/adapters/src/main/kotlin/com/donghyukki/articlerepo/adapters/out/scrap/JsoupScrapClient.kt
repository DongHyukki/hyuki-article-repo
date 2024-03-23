package com.donghyukki.articlerepo.adapters.out.scrap

import com.donghyukki.articlerepo.core.domain.article.model.ScrappedData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import org.springframework.stereotype.Component

@Component
class JsoupScrapClient {
    suspend fun scrap(url: String) = withContext(Dispatchers.IO) {
        val doc: Document = Jsoup.connect(url).get()
        val title: String = doc.select("meta[property=og:title]").attr("content")
        val description: String = doc.select("meta[property=og:description]")
            .attr("content")
            .toDescription()
        val image: String = doc.select("meta[property=og:image]").attr("content")

        ScrappedData(
            title = title,
            description = description,
            imageUrl = image
        )
    }

    fun String.toDescription(): String {
        return if (this.count() > MAX_DESCRIPTION_LENGTH) {
            this.substring(0..50) + "..."
        } else {
            this
        }.replace(replacePattern, "")
    }

    companion object {
        const val MAX_DESCRIPTION_LENGTH = 30
        val replacePattern = "[\\n\\t\\r\\f]".toRegex()
    }
}
