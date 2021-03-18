package com.example.easynvestapp.data.repository

import com.example.easynvestapp.utils.ResultSimulation

interface MainRepository {

    suspend fun getApiResult(): ResultSimulation

}