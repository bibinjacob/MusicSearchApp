package com.bibin.music.musicmanagement.presentation

import com.bibin.music.musicmanagement.presentation.entity.Album

interface ListItemClickCallback {

    fun onItemClick(album: Album)
}