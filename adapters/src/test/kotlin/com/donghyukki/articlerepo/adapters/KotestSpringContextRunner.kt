package com.donghyukki.articlerepo.adapters

import org.springframework.boot.test.context.SpringBootTest
import org.springframework.context.annotation.Import
import org.springframework.test.context.ActiveProfiles

@SpringBootTest(
    webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
    classes = [KotestSpringContextConfigurer::class]
)
@ActiveProfiles("test")
@Import(AbstractR2dbcTest::class)
interface KotestSpringContextRunner
