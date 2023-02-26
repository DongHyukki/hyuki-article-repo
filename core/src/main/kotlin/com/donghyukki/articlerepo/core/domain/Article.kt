package com.donghyukki.articlerepo.core.domain

class Article constructor(
    private val id: Long,
    private val url: String
) {

    constructor(url: String) : this(0, url)

    fun getId(): Long = id
    fun getUrl(): String = url
}
