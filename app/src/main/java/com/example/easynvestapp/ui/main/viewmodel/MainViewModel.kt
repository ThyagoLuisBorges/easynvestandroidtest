package com.example.easynvestapp.ui.main.viewmodel

import androidx.lifecycle.*
import com.example.easynvestapp.data.repository.MainRepository
import com.example.easynvestapp.data.repository.MainRepositoryImpl
import com.example.easynvestapp.utils.ResultSimulation
import kotlinx.coroutines.launch

class MainViewModel(private val mainRepository: MainRepository) : ViewModel() {

    private val event = MutableLiveData<ResultSimulation>()
    val eventView: LiveData<ResultSimulation> = event

    fun getResult() {
        viewModelScope.launch {
            event.value = mainRepository.getApiResult()
        }
    }

}