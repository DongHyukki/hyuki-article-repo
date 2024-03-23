package com.donghyukki.articlerepo.support.dto

data class Page<T>(
    val pageable: Pageable,
    val content: List<T>,
    val totalElements: Int
) {
    fun getTotalPage(): Int {
        return totalElements / pageable.size + 1
    }
}
