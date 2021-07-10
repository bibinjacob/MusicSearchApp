package com.bibin.music.splash.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.bibin.music.R
import com.bibin.music.base.presentation.BaseFragment
import com.bibin.music.databinding.FragmentSplashBinding

class SplashFragment : BaseFragment() {

    private lateinit var binding: FragmentSplashBinding
    private lateinit var splashViewModel: SplashViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSplashBinding.inflate(inflater, container, false)
        splashViewModel = ViewModelProvider(this, viewModelFactory).get(SplashViewModel::class.java)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setObservers()
    }

    private fun setObservers() {
        splashViewModel.timerLiveData.observe(viewLifecycleOwner, Observer { timeOut ->

            if (timeOut) {
                findNavController().navigate(R.id.action_splash_to_music_search_category_fragment)
            }
        })
    }
}