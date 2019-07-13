package com.mindev.presentation

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import dagger.android.support.DaggerAppCompatActivity

abstract class MinDevActivity<B : ViewDataBinding> : DaggerAppCompatActivity() {
    abstract val layoutResource: Int
    lateinit var viewDataBinding: B

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewDataBinding = DataBindingUtil.setContentView(this, layoutResource)
    }
}
