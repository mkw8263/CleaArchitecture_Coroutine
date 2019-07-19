package com.common

import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders

fun <T : ViewModel> AppCompatActivity.createViewModel(
    factory: ViewModelProvider.Factory, classType: Class<T>
): T = ViewModelProviders.of(this, factory)[classType]


fun AppCompatActivity.toast(message: String) =
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
