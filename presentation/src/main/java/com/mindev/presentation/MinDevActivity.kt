package com.mindev.presentation

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.coroutines.Job

abstract class MinDevActivity<B : ViewDataBinding> : DaggerAppCompatActivity() {
    abstract val layoutResource: Int
    lateinit var viewDataBinding: B
    var job: Job? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewDataBinding = DataBindingUtil.setContentView(this, layoutResource)
        viewDataBinding()
    }

    abstract fun viewDataBinding()
    override fun onDestroy() {
        super.onDestroy()
        job?.cancel()
    }
}
