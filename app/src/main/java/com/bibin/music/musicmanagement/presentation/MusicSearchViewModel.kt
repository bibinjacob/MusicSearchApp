package com.bibin.music.musicmanagement.presentation

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.bibin.music.base.domain.entity.mapToPresentationAlbum
import com.bibin.music.base.presentation.BaseViewModel
import com.bibin.music.base.presentation.Status
import com.bibin.music.base.presentation.responseEntityToResponse
import com.bibin.music.musicmanagement.domain.MusicSearchUseCase
import com.bibin.music.musicmanagement.presentation.entity.Album
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class MusicSearchViewModel @Inject constructor(private val musicSearchUseCase: MusicSearchUseCase) :
    BaseViewModel() {
    private var disposable: Disposable? = null
    val musicListObservable = MutableLiveData<List<Album>>()

    fun searchMusicByAlbum(album: String) {
        if (responseStatusLiveData.value != Status.Loading) {
            disposable?.dispose()
            responseStatusLiveData.postValue(Status.Loading)
            disposable =
                musicSearchUseCase.searchMusicByAlbumName(album).subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread()).map {
                        //api call is success when status = OK
                        musicListObservable.value = it.results?.mapToPresentationAlbum()
                        //Handle loading and api error cases if any
                        handleApiResponse(it.responseEntityToResponse())
                    }.onErrorReturn {
                        Log.d("HttpError :", "$it")
                    }.subscribe()

            disposable?.let { addDisposable(it) }
        }
    }
}