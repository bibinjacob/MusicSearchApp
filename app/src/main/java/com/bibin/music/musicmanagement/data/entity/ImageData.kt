package com.bibin.music.musicmanagement.data.entity

import com.google.gson.annotations.SerializedName

data class ImageData(
    @SerializedName("#text")
    val url: String = "",
    val size: String = ""
)