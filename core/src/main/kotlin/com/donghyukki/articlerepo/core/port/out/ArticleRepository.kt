package com.donghyukki.articlerepo.core.port.out

import com.donghyukki.articlerepo.core.domain.Article

interface ArticleRepository {
    suspend fun save(article: Article): Article
    suspend fun findById(id: Long): Article?
    suspend fun findAllOrderByDesc(): List<Article>
}
