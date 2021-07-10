package com.bibin.music.musicmanagement.data.entity

import com.google.gson.annotations.SerializedName

data class MusicSearchResponseData(
    @SerializedName("albummatches")
    val albumMatches: AlbumList?=null
)