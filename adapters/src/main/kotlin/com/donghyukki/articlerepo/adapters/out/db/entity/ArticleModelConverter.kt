package com.donghyukki.articlerepo.adapters.out.db.entity

import com.donghyukki.articlerepo.core.domain.article.model.Article
import com.donghyukki.articlerepo.core.domain.article.model.ArticleMetaData

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
