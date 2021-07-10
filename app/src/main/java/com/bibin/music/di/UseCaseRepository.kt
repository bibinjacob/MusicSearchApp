package com.bibin.music.di

import com.bibin.music.musicmanagement.data.MusicSearchRepository
import com.bibin.music.musicmanagement.domain.MusicSearchUseCase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class UseCaseRepository {

    @Singleton
    @Provides
    fun provideMusicSearchUseCase(musicSearchRepository: MusicSearchRepository): MusicSearchUseCase {
        return MusicSearchUseCase(musicSearchRepository)
    }
}