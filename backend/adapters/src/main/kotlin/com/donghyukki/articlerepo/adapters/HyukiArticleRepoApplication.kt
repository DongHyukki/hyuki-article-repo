package com.donghyukki.articlerepo.adapters

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication(scanBasePackages = ["com.donghyukki.articlerepo"])
class HyukiArticleRepoApplication

fun main(args: Array<String>) {
    runApplication<HyukiArticleRepoApplication>(*args)
}
