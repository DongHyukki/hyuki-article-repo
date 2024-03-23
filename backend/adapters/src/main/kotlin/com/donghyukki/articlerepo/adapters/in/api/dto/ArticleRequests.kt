package com.donghyukki.articlerepo.adapters.`in`.api.dto

import com.donghyukki.articlerepo.core.port.article.`in`.dto.ArticleCommands

object ArticleRequests {

    data class SaveRequest(
        val url: String
    ) {
        fun toCommand() = ArticleCommands.Save(
            url = url
        )
    }
}
