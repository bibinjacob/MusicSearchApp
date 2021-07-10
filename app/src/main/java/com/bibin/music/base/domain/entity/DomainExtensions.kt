package com.bibin.music.base.domain.entity

import com.bibin.music.musicmanagement.domain.entity.*
import com.bibin.music.musicmanagement.presentation.entity.Album
import com.bibin.music.musicmanagement.presentation.entity.Image

fun MusicSearchResponseEntity.mapToPresentationAlbum(): List<Album> {
    val albums: MutableList<Album> = mutableListOf()
    this.albumMatches?.map {
        albums.add(it.mapToAlbum())
    }
    return albums
}

private fun AlbumEntity.mapToAlbum(): Album {
    return Album(
        name = this.name ?: "",
        artist = this.artist ?: "",
        image = this.image?.mapToImageList()
    )
}

private fun List<ImageEntity>.mapToImageList(): List<Image> {
    val images: MutableList<Image> = mutableListOf()
    this.map {
        images.add(Image(url = it.url, size = it.size))
    }
    return images
}