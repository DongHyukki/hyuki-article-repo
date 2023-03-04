package com.donghyukki.articlerepo.adapters.`in`.api

import com.donghyukki.articlerepo.adapters.AbstractR2dbcTest
import com.donghyukki.articlerepo.adapters.`in`.api.dto.ArticleRequests
import io.kotest.core.spec.style.BehaviorSpec
import org.hamcrest.Matchers.`is`
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient
import org.springframework.test.web.reactive.server.WebTestClient
import reactor.kotlin.core.publisher.toMono

@AutoConfigureWebTestClient(timeout = "PT10M")
internal class ArticleApiTest(
    private val client: WebTestClient
) : AbstractR2dbcTest, BehaviorSpec({

    Given("Article 저장") {
        When("정상적인 요청일때") {
            Then("저장에 성공해야 한다.") {
                client.post()
                    .uri("/api/v1/article")
                    .body(ArticleRequests.SaveRequest("test.url").toMono(), ArticleRequests.SaveRequest::class.java)
                    .exchange()
                    .expectStatus()
                    .isOk
                    .expectBody()
                    .jsonPath("$.data", `is`("test.url"))
            }
        }
    }
})
