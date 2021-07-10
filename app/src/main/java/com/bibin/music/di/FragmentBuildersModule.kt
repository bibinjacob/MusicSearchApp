package com.bibin.music.di

import com.bibin.music.musicmanagement.presentation.MusicSearchCategoryFragment
import com.bibin.music.musicmanagement.presentation.MusicListFragment
import com.bibin.music.musicmanagement.presentation.MusicDetailsFragment
import com.bibin.music.splash.presentation.SplashFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentBuildersModule {

    @ContributesAndroidInjector
    abstract fun contributeSplashFragment(): SplashFragment

    @ContributesAndroidInjector
    abstract fun contributeMusicSearchCategoryFragmentt(): MusicSearchCategoryFragment

    @ContributesAndroidInjector
    abstract fun contributeMusicListFragment(): MusicListFragment

    @ContributesAndroidInjector
    abstract fun contributeMusicDetailsFragment(): MusicDetailsFragment

}