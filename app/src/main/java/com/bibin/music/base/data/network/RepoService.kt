package com.bibin.music.base.data.network

import com.bibin.music.base.data.network.entity.ResponseData
import com.bibin.music.musicmanagement.data.entity.MusicSearchResponseData
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Retrofit class for apis
 * */
interface RepoService {

    @GET("2.0/?method=album.search")
    fun searchAlbum(
        @Query(value = "album", encoded = true) album: String,
        @Query(value = "api_key", encoded = true) apiKey: String,
        @Query(value = "format", encoded = true) format: String
    ): Single<ResponseData<MusicSearchResponseData>>
}