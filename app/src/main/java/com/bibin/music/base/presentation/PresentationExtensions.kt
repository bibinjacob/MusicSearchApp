package com.bibin.music.base.presentation

import com.bibin.music.base.domain.entity.ResponseEntity
import com.bibin.music.musicmanagement.presentation.entity.Image

fun <T> ResponseEntity<T>.responseEntityToResponse(): Response {
    return Response(
        status = this.status,
        statusCode = this.statusCode,
        message = this.message,
        errors = this.errors
    )
}

fun getImageUrlBasedOnSize(images: List<Image>?, size: String): String {
    var url = ""
    images?.map {
        if (it.size == size)
            url = it.url
    }
    return url
}