package com.bibin.music.musicmanagement.presentation

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.bibin.music.base.domain.entity.ResponseEntity
import com.bibin.music.musicmanagement.domain.MusicSearchUseCase
import com.bibin.music.musicmanagement.domain.entity.AlbumEntity
import com.bibin.music.musicmanagement.domain.entity.MusicSearchResponseEntity
import io.reactivex.Single
import junit.framework.TestCase
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class MusicSearchViewModelTest : TestCase() {
    @Rule
    @JvmField
    val instantExecutorRule = InstantTaskExecutorRule()

    @Mock
    lateinit var musicSearchUseCase: MusicSearchUseCase

    private lateinit var viewModel: MusicSearchViewModel

    @Before
    public override fun setUp() {
        viewModel = MusicSearchViewModel(musicSearchUseCase)
    }

    @Test
    fun ` verify albumMatches size is notEmpty when searchMusicByAlbum`() {
        //given
        val album = "Believe"
        val responseEntityMock =
            ResponseEntity(results = MusicSearchResponseEntity(albumMatches = createAlbumMatchesList()))
        val musicSearchResponseEntityMock = Single.just(responseEntityMock)
        `when`(musicSearchUseCase.searchMusicByAlbumName(album)).thenReturn(musicSearchResponseEntityMock)

        //when
        viewModel.searchMusicByAlbum(album)

        //then
        viewModel.musicListObservable.observeForever {
            val listSize = viewModel.musicListObservable.value
            assertTrue(listSize?.size ?: 0 > 0)
        }
    }

    private fun createAlbumMatchesList(): List<AlbumEntity> {

        val albums: MutableList<AlbumEntity> = mutableListOf()
        albums.add(
            AlbumEntity(
                name = "Believe",
                artist = "Sam",
                image = listOf()
            )
        )
        return albums
    }
}