package com.bibin.music.musicmanagement.presentation.entity

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Image(
    val url: String = "",
    val size: String = ""
) : Parcelable