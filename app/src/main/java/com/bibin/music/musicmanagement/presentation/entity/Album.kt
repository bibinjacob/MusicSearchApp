package com.bibin.music.musicmanagement.presentation.entity

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Album(
    val name: String? = "",
    val artist: String? = "",
    val image: List<Image>? = null
): Parcelable