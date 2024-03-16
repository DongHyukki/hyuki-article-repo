package com.donghyukki.articlerepo.core.port.article.`in`

import com.donghyukki.articlerepo.core.domain.article.model.Article
import com.donghyukki.articlerepo.core.port.article.`in`.dto.ArticleCommands

interface ArticleUseCase {
    suspend fun saveArticle(save: ArticleCommands.Save): Article
    suspend fun findArticleById(id: Long): Article
    suspend fun findAllArticles(): List<Article>
}
