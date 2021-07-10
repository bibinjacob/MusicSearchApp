package com.bibin.music.musicmanagement.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.bibin.music.R
import com.bibin.music.base.presentation.BaseFragment
import com.bibin.music.base.presentation.getImageUrlBasedOnSize
import com.bibin.music.databinding.FragmentMusicDetailsBinding
import com.bibin.music.musicmanagement.presentation.entity.Album
import com.bumptech.glide.Glide

class MusicDetailsFragment : BaseFragment() {
    lateinit var binding: FragmentMusicDetailsBinding
    private lateinit var musicDetailViewModel: MusicDetailViewModel
    private var album: Album? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMusicDetailsBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this
        musicDetailViewModel =
            ViewModelProvider(this, viewModelFactory).get(MusicDetailViewModel::class.java)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
    }

    private fun initViews() {
        fetchArguments()
    }

    private fun fetchArguments() {
        arguments?.let {
            album = it.getParcelable(getString(R.string.arg_album))
            binding.album = album
            context?.let { it1 -> Glide.with(it1).load(getImageUrlBasedOnSize(album?.image, "extralarge")).into(binding.imageAlbum) }
        }
    }
}