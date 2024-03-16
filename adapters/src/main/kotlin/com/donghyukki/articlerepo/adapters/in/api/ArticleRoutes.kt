package com.donghyukki.articlerepo.adapters.`in`.api

import com.donghyukki.articlerepo.adapters.`in`.api.dto.ApiResponse
import com.donghyukki.articlerepo.adapters.`in`.api.dto.ArticleRequests
import com.donghyukki.articlerepo.core.domain.article.model.Article
import com.donghyukki.articlerepo.core.port.article.`in`.ArticleUseCase
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/api/v1/article")
@RestController
class ArticleRoutes(
    private val articleUseCase: ArticleUseCase
) {

    @GetMapping
    suspend fun getAllArticles(): ApiResponse<List<Article>> {
        return ApiResponse.success(articleUseCase.findAllArticles())
    }

    @PostMapping
    suspend fun saveArticle(request: ArticleRequests.SaveRequest): ApiResponse<Article> {
        return ApiResponse.success(articleUseCase.saveArticle(request.toCommand()))
    }
}
