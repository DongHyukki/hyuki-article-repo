package com.donghyukki.articlerepo.adapters

import org.springframework.boot.test.autoconfigure.web.client.AutoConfigureWebClient
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles

@SpringBootTest(
    webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
    classes = [KotestSpringContextConfigurer::class]
)
@AutoConfigureWebClient
@ActiveProfiles("test")
interface KotestSpringContextRunner
