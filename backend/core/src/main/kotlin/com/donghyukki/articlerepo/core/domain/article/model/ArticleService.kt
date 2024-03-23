package com.donghyukki.articlerepo.core.domain.article.model

import com.donghyukki.articlerepo.core.port.article.`in`.ArticleUseCase
import com.donghyukki.articlerepo.core.port.article.`in`.dto.ArticleCommands.Save
import com.donghyukki.articlerepo.core.port.article.out.ArticleRepository
import com.donghyukki.articlerepo.core.port.article.out.ArticleScrapClient
import com.donghyukki.articlerepo.support.dto.Page
import com.donghyukki.articlerepo.support.dto.Pageable
import org.springframework.stereotype.Service

@Service
class ArticleService(
    private val articleRepository: ArticleRepository,
    private val articleScrapClient: ArticleScrapClient
) : ArticleUseCase {

    override suspend fun saveArticle(save: Save): Article {
        val scrappedData = articleScrapClient.scrap(save.url)
        val article = Article(save.url, scrappedData)
        return articleRepository.save(article)
    }

    override suspend fun findArticleById(id: Long): Article {
        return checkNotNull(articleRepository.findById(id))
    }

    override suspend fun findAllArticles(pageable: Pageable): Page<Article> {
        return articleRepository.findAll(pageable)
    }
}
