package com.donghyukki.articlerepo.core.port.out

import com.donghyukki.articlerepo.core.domain.ScrappedData

interface ArticleScrapClient {
    fun scrap(url: String): ScrappedData
}
