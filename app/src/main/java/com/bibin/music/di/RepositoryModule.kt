package com.bibin.music.di

import com.bibin.music.base.data.network.RepoService
import com.bibin.music.musicmanagement.data.MusicSearchRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Singleton
    @Provides
    fun provideMusicSearchRepository(repoService: RepoService): MusicSearchRepository {
        return MusicSearchRepository(repoService)
    }
}