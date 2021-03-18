package com.example.easynvestapp.ui.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.easynvestapp.data.api.ApiService
import com.example.easynvestapp.ui.main.viewmodel.MainViewModel
import com.example.easynvestapp.utils.providerRepository

class ViewModelFactory(private val apiService: ApiService) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            return MainViewModel(providerRepository) as T
        }
        throw IllegalArgumentException("Unknown class name")
    }

}