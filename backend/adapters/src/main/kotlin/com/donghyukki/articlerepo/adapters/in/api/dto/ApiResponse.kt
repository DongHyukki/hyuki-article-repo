package com.donghyukki.articlerepo.adapters.`in`.api.dto

import com.donghyukki.articlerepo.support.extensions.toCode
import org.springframework.http.HttpStatus

data class ApiResponse<T>(
    val code: String,
    val data: T? = null
) {

    companion object {
        fun <T> success(data: T): ApiResponse<T> {
            return ApiResponse(HttpStatus.OK.toCode(), data)
        }

        fun success(): ApiResponse<Nothing> {
            return ApiResponse(HttpStatus.OK.toCode(), null)
        }
    }
}
