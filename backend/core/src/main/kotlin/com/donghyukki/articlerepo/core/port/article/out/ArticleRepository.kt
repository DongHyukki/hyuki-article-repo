package com.donghyukki.articlerepo.core.port.article.out

import com.donghyukki.articlerepo.core.domain.article.model.Article
import com.donghyukki.articlerepo.support.dto.Page
import com.donghyukki.articlerepo.support.dto.Pageable

interface ArticleRepository {
    suspend fun save(article: Article): Article
    suspend fun findById(id: Long): Article?
    suspend fun findAll(pageable: Pageable): Page<Article>
}
