package com.bibin.music.musicmanagement.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.bibin.music.R
import com.bibin.music.base.presentation.BaseFragment
import com.bibin.music.databinding.FragmentMusicListBinding
import com.bibin.music.musicmanagement.presentation.entity.Album

class MusicListFragment : BaseFragment() {
    lateinit var binding: FragmentMusicListBinding
    private lateinit var musicSearchViewModel: MusicSearchViewModel
    private lateinit var musicListAdapter: MusicListAdapter
    private var musicList = mutableListOf<Album>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMusicListBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this
        musicSearchViewModel =
            ViewModelProvider(this, viewModelFactory).get(MusicSearchViewModel::class.java)
        binding.musicListViewModel = musicSearchViewModel
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setObservers()
        initViews()
    }

    private fun initViews() {
        musicListAdapter = MusicListAdapter(musicList, listItemClickCallback)
        binding.recyclerViewMusicList.adapter = musicListAdapter
        binding.btnSearch.setOnClickListener {
            val album = binding.etAlbumName.text.toString()
            if (album.isNotEmpty())
                musicSearchViewModel.searchMusicByAlbum(album)
        }
    }

    private fun setObservers() {
        musicSearchViewModel.musicListObservable.observe(viewLifecycleOwner, Observer {
            musicListAdapter.updateList(it)
        })
    }

    private val listItemClickCallback = object : ListItemClickCallback {
        override fun onItemClick(album: Album) {
            val bundle = Bundle().apply {
                putParcelable(
                    getString(R.string.arg_album),
                    album
                )
            }
            findNavController().navigate(
                R.id.action_fragmentMusicList_to_fragmentMusicDetails,
                bundle
            )
        }
    }
}