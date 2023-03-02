package com.donghyukki.articlerepo.adapters.extensions

import org.springframework.http.HttpStatus

fun HttpStatus.toCode(): String {
    return this.value().toString()
}
