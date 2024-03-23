package com.donghyukki.articlerepo.adapters.out.db.repository

import com.donghyukki.articlerepo.adapters.out.db.entity.ArticleEntity
import org.springframework.data.domain.Pageable
import org.springframework.data.r2dbc.repository.R2dbcRepository
import reactor.core.publisher.Flux

interface R2dbcArticleRepository : R2dbcRepository<ArticleEntity, Long> {
    fun findAllBy(pageable: Pageable): Flux<ArticleEntity>
}
