package com.bibin.music.base.data.network.entity

import com.bibin.music.base.domain.entity.ResponseEntity
import com.bibin.music.musicmanagement.data.entity.AlbumData
import com.bibin.music.musicmanagement.data.entity.ImageData
import com.bibin.music.musicmanagement.data.entity.MusicSearchResponseData
import com.bibin.music.musicmanagement.domain.entity.AlbumEntity
import com.bibin.music.musicmanagement.domain.entity.ImageEntity
import com.bibin.music.musicmanagement.domain.entity.MusicSearchResponseEntity


fun ResponseData<MusicSearchResponseData>.mapToMusicSearchResponseEntity(): ResponseEntity<MusicSearchResponseEntity> {
    return ResponseEntity(
        results = this.results?.mapToResultEntity(),
        message = this.message,
        statusCode = this.statusCode,
        status = this.status,
        errors = this.errors
    )
}

fun AlbumData.mapToAlbumEntity(): AlbumEntity {
    return AlbumEntity(
        name = this.name,
        artist = this.artist,
        image = this.image?.map {
            it.mapToImageEntity()
        }
    )
}

fun MusicSearchResponseData.mapToResultEntity(): MusicSearchResponseEntity {
    return MusicSearchResponseEntity(
        albumMatches = this.albumMatches?.album?.map {
            it.mapToAlbumEntity()
        }
    )
}

private fun ImageData.mapToImageEntity(): ImageEntity {
    return ImageEntity(
        url = this.url ?: "",
        size = this.size ?: ""
    )
}

