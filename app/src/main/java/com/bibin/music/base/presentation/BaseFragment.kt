package com.bibin.music.base.presentation

import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.bibin.music.di.Injectable
import javax.inject.Inject

open class BaseFragment : Fragment(), Injectable {
    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

}