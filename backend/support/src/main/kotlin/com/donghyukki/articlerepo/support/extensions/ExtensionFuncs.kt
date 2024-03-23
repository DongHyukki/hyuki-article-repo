package com.donghyukki.articlerepo.support.extensions

import org.springframework.http.HttpStatus

fun HttpStatus.toCode(): String {
    return this.value().toString()
}
