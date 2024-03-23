package com.donghyukki.articlerepo.core.port.article.`in`

import com.donghyukki.articlerepo.core.domain.article.model.Article
import com.donghyukki.articlerepo.core.port.article.`in`.dto.ArticleCommands
import com.donghyukki.articlerepo.support.dto.Page
import com.donghyukki.articlerepo.support.dto.Pageable

interface ArticleUseCase {
    suspend fun saveArticle(save: ArticleCommands.Save): Article
    suspend fun findArticleById(id: Long): Article
    suspend fun findAllArticles(pageable: Pageable): Page<Article>
}
