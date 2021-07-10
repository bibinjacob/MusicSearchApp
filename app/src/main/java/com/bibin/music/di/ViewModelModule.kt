package com.bibin.music.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.bibin.music.musicmanagement.presentation.MusicDetailViewModel
import com.bibin.music.musicmanagement.presentation.MusicSearchViewModel
import com.bibin.music.splash.presentation.SplashViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {

    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(SplashViewModel::class)
    abstract fun bindSplashViewModel(splashViewModel: SplashViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(MusicSearchViewModel::class)
    abstract fun bindMusicSearchViewModel(musicSearchViewModel: MusicSearchViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(MusicDetailViewModel::class)
    abstract fun bindMusicDetailViewModel(musicDetailViewModel: MusicDetailViewModel): ViewModel
}