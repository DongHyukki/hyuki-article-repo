package com.donghyukki.articlerepo.adapters.out.db.entity

import com.donghyukki.articlerepo.core.domain.Article
import reactor.core.publisher.Mono
import reactor.kotlin.core.publisher.toMono

object ArticleModelConverter {

    fun toEntity(article: Article): ArticleEntity {
        return ArticleEntity(
            id = article.getId(),
            url = article.getUrl()
        )
    }

    fun toModel(articleEntity: ArticleEntity): Article {
        return Article(
            id = articleEntity.id,
            url = articleEntity.url
        )
    }

    fun toMonoModel(articleEntity: ArticleEntity): Mono<Article> {
        return Article(
            id = articleEntity.id,
            url = articleEntity.url
        ).toMono()
    }
}
