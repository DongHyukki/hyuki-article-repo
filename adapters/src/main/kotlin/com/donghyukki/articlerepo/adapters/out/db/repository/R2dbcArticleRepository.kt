package com.donghyukki.articlerepo.adapters.out.db.repository

import com.donghyukki.articlerepo.adapters.out.db.entity.ArticleEntity
import com.donghyukki.articlerepo.adapters.out.db.entity.ArticleModelConverter
import com.donghyukki.articlerepo.core.domain.Article
import com.donghyukki.articlerepo.core.port.out.ArticleRepository
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.reactive.asFlow
import kotlinx.coroutines.reactor.awaitSingle
import kotlinx.coroutines.reactor.awaitSingleOrNull
import org.springframework.data.domain.Sort
import org.springframework.data.domain.Sort.Order.desc
import org.springframework.data.r2dbc.core.R2dbcEntityTemplate
import org.springframework.data.relational.core.query.Criteria
import org.springframework.data.relational.core.query.CriteriaDefinition
import org.springframework.data.relational.core.query.Query.query
import org.springframework.stereotype.Repository
import reactor.kotlin.core.publisher.toMono

@Repository
class R2dbcArticleRepository(
    private val template: R2dbcEntityTemplate
) : ArticleRepository {

    companion object {
        const val REAL_ARTICLE_TABLE_NAME = "article"
    }

    override suspend fun save(article: Article): Article {
        val articleEntity = template
            .insert(ArticleModelConverter.toEntity(article))
            .awaitSingle()

        return ArticleModelConverter.toModel(articleEntity)
    }

    override suspend fun findById(id: Long): Article? {
        val articleEntity = template.selectOne(
            query(
                Criteria.where("id").`is`(id)
            ),
            ArticleEntity::class.java
        ).awaitSingleOrNull()

        return articleEntity?.let {
            ArticleModelConverter.toModel(articleEntity)
        }
    }

    override suspend fun findAllOrderByDesc(): List<Article> {
        return template.select(ArticleEntity::class.java)
            .from(REAL_ARTICLE_TABLE_NAME)
            .matching(
                query(
                    CriteriaDefinition.empty()
                ).sort(
                    Sort.by(desc("id"))
                )
            ).all()
            .flatMap { ArticleModelConverter.toModel(it).toMono() }
            .asFlow()
            .toList()
    }
}
