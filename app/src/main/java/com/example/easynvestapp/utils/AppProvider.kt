package com.example.easynvestapp.utils

import com.example.easynvestapp.data.api.RetrofitBuilder
import com.example.easynvestapp.data.repository.MainRepositoryImpl
import com.example.easynvestapp.data.repository.MainRepositoryMockImpl

val providerRepository = MainRepositoryImpl(RetrofitBuilder.apiService)
//val providerRepository = MainRepositoryMockImpl()