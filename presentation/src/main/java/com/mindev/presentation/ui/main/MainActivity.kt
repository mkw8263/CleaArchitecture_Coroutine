package com.mindev.presentation.ui.main

import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.common.createViewModel
import com.mindev.presentation.MinDevActivity
import com.mindev.presentation.R
import com.mindev.presentation.databinding.ActivityMainBinding
import javax.inject.Inject

class MainActivity : MinDevActivity<ActivityMainBinding>() {
    override val layoutResource: Int = R.layout.activity_main

    @Inject
    lateinit var factory: ViewModelProvider.Factory

    private val viewModel by lazy { createViewModel(factory, MainActivityViewModel::class.java) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel.test()
    }
}
