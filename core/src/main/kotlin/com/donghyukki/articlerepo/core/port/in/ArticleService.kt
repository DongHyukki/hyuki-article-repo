package com.donghyukki.articlerepo.core.port.`in`

import com.donghyukki.articlerepo.core.domain.Article
import com.donghyukki.articlerepo.core.port.`in`.dto.ArticleServiceDTO.Save
import com.donghyukki.articlerepo.core.port.out.ArticleRepository
import com.donghyukki.articlerepo.core.port.out.ArticleScrapClient
import org.springframework.stereotype.Service

@Service
class ArticleService(
    private val articleRepository: ArticleRepository,
    private val articleScrapClient: ArticleScrapClient
) {

    suspend fun saveArticle(save: Save): Article {
        val scrappedData = articleScrapClient.scrap(save.url)
        val article = Article(save.url, scrappedData)
        return articleRepository.save(article)
    }

    suspend fun findArticleById(id: Long): Article {
        return checkNotNull(articleRepository.findById(id))
    }

    suspend fun findAllArticles(): List<Article> {
        return articleRepository.findAllOrderByDesc()
    }
}
