package com.donghyukki.articlerepo.adapters.out.db.entity

import com.donghyukki.articlerepo.core.domain.Article
import com.donghyukki.articlerepo.core.domain.ArticleMetaData
import reactor.core.publisher.Mono
import reactor.kotlin.core.publisher.toMono

object ArticleModelConverter {

    fun toEntity(article: Article): ArticleEntity {
        return ArticleEntity(
            id = article.getId(),
            url = article.getUrl(),
            title = article.getMetaData().title,
            description = article.getMetaData().description,
            imageUrl = article.getMetaData().imageUrl
        )
    }

    fun toModel(articleEntity: ArticleEntity): Article {
        return Article(
            id = articleEntity.id,
            url = articleEntity.url,
            metaData = ArticleMetaData(
                title = articleEntity.title,
                description = articleEntity.description,
                imageUrl = articleEntity.imageUrl
            )
        )
    }
}
