package com.bibin.music.musicmanagement.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.bibin.music.R
import com.bibin.music.base.presentation.BaseFragment
import com.bibin.music.databinding.FragmentMusicSearchCategoryBinding

class MusicSearchCategoryFragment : BaseFragment() {

    lateinit var binding: FragmentMusicSearchCategoryBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMusicSearchCategoryBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnAlbum.setOnClickListener {
            findNavController().navigate(R.id.action_fragmentMusicSearchCat_to_fragmentMusicList)
        }
    }
}