package com.bibin.music.musicmanagement.domain

import com.bibin.music.base.domain.entity.ResponseEntity
import com.bibin.music.musicmanagement.data.MusicSearchRepository
import com.bibin.music.musicmanagement.domain.entity.MusicSearchResponseEntity
import io.reactivex.Single
import javax.inject.Inject

class MusicSearchUseCase @Inject constructor(private val musicSearchRepository: MusicSearchRepository) {

    fun searchMusicByAlbumName(album: String): Single<ResponseEntity<MusicSearchResponseEntity>> {
        return musicSearchRepository.searchAlbum(album)
    }
}