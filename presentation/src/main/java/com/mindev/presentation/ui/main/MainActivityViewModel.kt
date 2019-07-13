package com.mindev.presentation.ui.main

import android.util.Log
import androidx.lifecycle.ViewModel
import javax.inject.Inject

class MainActivityViewModel @Inject constructor() : ViewModel() {


    fun test(){
        Log.e("Ww","www")
    }
    override fun onCleared() {
        super.onCleared()
    }
}
