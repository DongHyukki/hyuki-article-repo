package com.donghyukki.articlerepo.adapters.out.scrap

import com.donghyukki.articlerepo.core.domain.article.model.ScrappedData
import com.donghyukki.articlerepo.core.port.article.out.ArticleScrapClient
import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import org.springframework.stereotype.Component

@Component
class JsoupScrapClient : ArticleScrapClient {

    override fun scrap(url: String): ScrappedData {
        val doc: Document = Jsoup.connect(url).get()
        val title: String = doc.select("meta[property=og:title]").attr("content")
        val description: String = doc.select("meta[property=og:description]").attr("content")
        val image: String = doc.select("meta[property=og:image]").attr("content")

        return ScrappedData(
            title = title,
            description = description,
            imageUrl = image
        )
    }
}
