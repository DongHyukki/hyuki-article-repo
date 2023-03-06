package com.donghyukki.articlerepo.adapters.out.db.entity

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table

@Table("article")
data class ArticleEntity(
    @Id
    val id: Long = 0,
    val url: String,
    val title: String,
    val description: String,
    val imageUrl: String
)
