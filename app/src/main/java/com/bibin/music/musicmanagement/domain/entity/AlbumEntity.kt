package com.bibin.music.musicmanagement.domain.entity

data class AlbumEntity(
    val name: String? = "",
    val artist: String? = "",
    val image: List<ImageEntity>? = null
)