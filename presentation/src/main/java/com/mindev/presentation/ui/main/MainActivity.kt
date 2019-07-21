package com.mindev.presentation.ui.main

import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import com.common.createViewModel
import com.common.ob
import com.common.toast
import com.mindev.presentation.MinDevActivity
import com.mindev.presentation.R
import com.mindev.presentation.databinding.ActivityMainBinding
import com.mindev.presentation.ui.main.adapter.NewsAdapter
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject


class MainActivity : MinDevActivity<ActivityMainBinding>() {
    override val layoutResource: Int = R.layout.activity_main
    @Inject
    lateinit var factory: ViewModelProvider.Factory

    private val viewModel by lazy { createViewModel(factory, MainActivityViewModel::class.java) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        ob(viewModel.resultStateLive, ::resultState)
    }

    private fun resultState(result: MainActivityViewModel.ResultState) {
        when (result) {
            is MainActivityViewModel.ResultState.ToastMessage -> toast(result.message)
            is MainActivityViewModel.ResultState.NewsList -> rv.adapter =
                NewsAdapter(result.items)
        }
    }

    override fun viewDataBinding() {
        viewDataBinding.apply {
            mainViewModel = viewModel
            lifecycleOwner = this@MainActivity
        }
    }

    fun onClick(view: View) {
        when (view.id) {
            R.id.btn_ok -> viewModel.getNewsInfo(et_input.text.toString())
        }
    }
}
