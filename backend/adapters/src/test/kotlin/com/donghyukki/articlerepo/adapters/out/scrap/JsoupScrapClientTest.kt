package com.donghyukki.articlerepo.adapters.out.scrap

import io.kotest.core.spec.style.FunSpec

internal class JsoupScrapClientTest(
    private val scrapClient: JsoupScrapClient = JsoupScrapClient()
) : FunSpec({
    test("scrap toss tech") {
        scrapClient.scrap("https://toss.tech/article/typescript-type-compatibility")
    }
})
