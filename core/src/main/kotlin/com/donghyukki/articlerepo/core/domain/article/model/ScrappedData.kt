package com.donghyukki.articlerepo.core.domain.article.model

data class ScrappedData(
    val title: String,
    val description: String,
    val imageUrl: String
) {
    fun toArticleMeta() = ArticleMetaData(
        title = this.title,
        description = this.description,
        imageUrl = this.imageUrl
    )
}
