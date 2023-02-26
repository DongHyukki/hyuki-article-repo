package com.donghyukki.articlerepo.adapters.out.db.repository

import com.donghyukki.articlerepo.adapters.out.db.entity.ArticleModelConverter
import com.donghyukki.articlerepo.core.domain.Article
import com.donghyukki.articlerepo.core.port.out.ArticleRepository
import kotlinx.coroutines.reactor.awaitSingle
import org.springframework.data.r2dbc.core.R2dbcEntityTemplate
import org.springframework.stereotype.Repository

@Repository
class R2dbcArticleRepository(
    private val template: R2dbcEntityTemplate
) : ArticleRepository {

    override suspend fun save(article: Article): Article {
        val articleEntity = template
            .insert(ArticleModelConverter.toEntity(article))
            .awaitSingle()

        return ArticleModelConverter.toModel(articleEntity)
    }
}
