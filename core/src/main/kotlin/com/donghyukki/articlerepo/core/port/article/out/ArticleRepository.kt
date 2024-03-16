package com.donghyukki.articlerepo.core.port.article.out

import com.donghyukki.articlerepo.core.domain.article.model.Article

interface ArticleRepository {
    suspend fun save(article: Article): Article
    suspend fun findById(id: Long): Article?
    suspend fun findAllOrderByDesc(): List<Article>
}
