package com.donghyukki.articlerepo.core.port.article.out

import com.donghyukki.articlerepo.core.domain.article.model.ScrappedData

interface ArticleScrapClient {
    fun scrap(url: String): ScrappedData
}
