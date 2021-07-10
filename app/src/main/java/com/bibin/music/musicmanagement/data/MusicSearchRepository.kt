package com.bibin.music.musicmanagement.data

import com.bibin.music.BuildConfig.API_KEY
import com.bibin.music.base.data.network.RepoService
import com.bibin.music.base.data.network.entity.mapToMusicSearchResponseEntity
import com.bibin.music.base.domain.entity.ResponseEntity
import com.bibin.music.musicmanagement.domain.entity.MusicSearchResponseEntity
import io.reactivex.Single
import javax.inject.Inject

class MusicSearchRepository @Inject constructor(private var repoService: RepoService) {

    fun searchAlbum(album: String): Single<ResponseEntity<MusicSearchResponseEntity>> {

        return repoService.searchAlbum(album, API_KEY,"json").map {
            it.mapToMusicSearchResponseEntity()
        }
    }
}