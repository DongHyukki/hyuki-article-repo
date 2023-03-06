package com.donghyukki.articlerepo.core.domain

class Article(
    private val id: Long,
    private val url: String,
    private val metaData: ArticleMetaData
) {

    constructor(url: String, scrappedData: ScrappedData) : this(0, url, scrappedData.toArticleMeta())

    fun getMetaData(): ArticleMetaData = metaData
    fun getId(): Long = id
    fun getUrl(): String = url
}
