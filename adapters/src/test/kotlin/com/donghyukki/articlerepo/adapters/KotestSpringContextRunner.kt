package com.donghyukki.articlerepo.adapters

import io.kotest.extensions.testcontainers.SharedTestContainerExtension
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.context.annotation.Import
import org.springframework.test.context.ActiveProfiles

@SpringBootTest(
    webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
    classes = [KotestSpringContextConfigurer::class]
)
@AutoConfigureWebTestClient(timeout = "PT10M")
@ActiveProfiles("test")
@Import(AbstractMysqlTest::class)
interface KotestSpringContextRunner {

    companion object {
        val sharedExt = SharedTestContainerExtension(AbstractMysqlTest.mysql)
    }
}
