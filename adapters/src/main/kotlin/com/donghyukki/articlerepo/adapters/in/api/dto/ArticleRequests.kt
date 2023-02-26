package com.donghyukki.articlerepo.adapters.`in`.api.dto

import com.donghyukki.articlerepo.core.domain.Article

object ArticleRequests {

    data class SaveRequest(
        val url: String
    ) {
        fun toModel(): Article {
            return Article(url)
        }
    }
}
