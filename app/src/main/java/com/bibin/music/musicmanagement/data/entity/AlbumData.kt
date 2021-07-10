package com.bibin.music.musicmanagement.data.entity

data class AlbumData(
    val name: String? = "",
    val artist: String? = "",
    val image: List<ImageData>? = null
)