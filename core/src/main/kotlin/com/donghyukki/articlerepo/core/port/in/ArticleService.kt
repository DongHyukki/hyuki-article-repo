package com.donghyukki.articlerepo.core.port.`in`

import com.donghyukki.articlerepo.core.domain.Article
import com.donghyukki.articlerepo.core.port.out.ArticleRepository
import org.springframework.stereotype.Service

@Service
class ArticleService(
    private val articleRepository: ArticleRepository
) {

    suspend fun saveArticle(article: Article): Article {
        return articleRepository.save(article)
    }

    suspend fun findArticleById(id: Long): Article {
        return checkNotNull(articleRepository.findById(id))
    }

    suspend fun findAllArticles(): List<Article> {
        return articleRepository.findAllOrderByDesc()
    }
}
