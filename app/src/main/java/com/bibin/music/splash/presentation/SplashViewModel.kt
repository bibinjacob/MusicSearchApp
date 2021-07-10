package com.bibin.music.splash.presentation

import androidx.lifecycle.MutableLiveData
import com.bibin.music.base.presentation.BaseViewModel
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

class SplashViewModel @Inject constructor() : BaseViewModel() {

    val timerLiveData = MutableLiveData(false)

    init {
        GlobalScope.launch {
            delay(3000)
            timerLiveData.postValue(true)
        }
    }
}