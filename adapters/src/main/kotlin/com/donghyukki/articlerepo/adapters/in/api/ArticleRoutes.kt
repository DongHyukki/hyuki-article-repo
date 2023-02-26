package com.donghyukki.articlerepo.adapters.`in`.api

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.MediaType
import org.springframework.web.reactive.function.server.coRouter

@Configuration
class ArticleRoutes(
    private val articleHandler: ArticleHandler
) {

    companion object {
        const val ARTICLE_API_PREFIX = "/api/v1/article"
    }

    @Bean
    fun route() = coRouter {
        ARTICLE_API_PREFIX.nest {
            accept(MediaType.APPLICATION_JSON).nest {
                POST("", articleHandler::saveArticle)
            }
        }
    }
}
