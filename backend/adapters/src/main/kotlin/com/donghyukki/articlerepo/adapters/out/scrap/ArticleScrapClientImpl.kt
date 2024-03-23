package com.donghyukki.articlerepo.adapters.out.scrap

import com.donghyukki.articlerepo.core.domain.article.model.ScrappedData
import com.donghyukki.articlerepo.core.port.article.out.ArticleScrapClient
import org.springframework.stereotype.Component

@Component
class ArticleScrapClientImpl(
    private val jsoupScrapClient: JsoupScrapClient,
    private val metaOpenGraphScrapClient: MetaOpenGraphScrapClient
) : ArticleScrapClient {
    override suspend fun scrap(url: String): ScrappedData {
        return runCatching { jsoupScrapClient.scrap(url) }.getOrNull()
            ?.takeUnless { it.isFail() }
            ?: metaOpenGraphScrapClient.scrap(url)
    }
}
