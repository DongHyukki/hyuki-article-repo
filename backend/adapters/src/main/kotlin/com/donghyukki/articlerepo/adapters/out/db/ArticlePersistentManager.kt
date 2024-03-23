package com.donghyukki.articlerepo.adapters.out.db

import com.donghyukki.articlerepo.adapters.out.db.entity.ArticleModelConverter
import com.donghyukki.articlerepo.adapters.out.db.repository.R2dbcArticleRepository
import com.donghyukki.articlerepo.core.domain.article.model.Article
import com.donghyukki.articlerepo.core.port.article.out.ArticleRepository
import com.donghyukki.articlerepo.support.dto.Page
import com.donghyukki.articlerepo.support.dto.Pageable
import kotlinx.coroutines.reactive.awaitSingle
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Sort
import org.springframework.stereotype.Component

@Component
class ArticlePersistentManager(
    private val repository: R2dbcArticleRepository
) : ArticleRepository {
    override suspend fun save(article: Article): Article {
        val articleEntity = repository
            .save(ArticleModelConverter.toEntity(article))
            .awaitSingle()

        return ArticleModelConverter.toModel(articleEntity)
    }

    override suspend fun findById(id: Long): Article? {
        val articleEntity = repository.findById(id).awaitSingle()

        return articleEntity?.let {
            ArticleModelConverter.toModel(articleEntity)
        }
    }

    override suspend fun findAll(pageable: Pageable): Page<Article> {
        val articleEntities = repository.findAllBy(pageable.toSpringPageable())
            .collectList()
            .awaitSingle()
        val totalElementsCount = repository.count().awaitSingle()

        return Page(
            pageable = pageable,
            content = articleEntities.map { ArticleModelConverter.toModel(it) },
            totalElements = totalElementsCount.toInt()
        )
    }

    private fun Pageable.toSpringPageable(): PageRequest {
        return PageRequest.of(this.page, this.size, Sort.by(listOf(Sort.Order.desc("id"))))
    }
}
