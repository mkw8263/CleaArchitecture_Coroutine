package com.mindev.presentation.ui.main

import android.os.Bundle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.mindev.presentation.MinDevActivity
import com.mindev.presentation.R
import com.mindev.presentation.databinding.ActivityMainBinding
import javax.inject.Inject

class MainActivity : MinDevActivity<ActivityMainBinding>() {
    override val layoutResource: Int = R.layout.activity_main

    @Inject
    lateinit var factory: ViewModelProvider.Factory
    override val viewModel: ViewModel =
        ViewModelProviders.of(this, factory)[MainActivityViewModel::class.java]

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

    }
}
