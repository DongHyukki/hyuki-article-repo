package com.donghyukki.articlerepo.core.port.out

import com.donghyukki.articlerepo.core.domain.Article

interface ArticleRepository {
    suspend fun save(article: Article): Article
}
