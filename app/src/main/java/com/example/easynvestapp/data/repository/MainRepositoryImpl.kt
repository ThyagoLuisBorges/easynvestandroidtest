package com.example.easynvestapp.data.repository

import com.example.easynvestapp.data.api.ApiService
import com.example.easynvestapp.data.model.Result
import com.example.easynvestapp.utils.ResultSimulation
import com.example.easynvestapp.utils.mapToResult
import java.lang.Exception

class MainRepositoryImpl(private val apiService: ApiService) : MainRepository {

    override suspend fun getApiResult(): ResultSimulation {
        return try {
            val result = apiService.getResult()
            val resultMap = result.mapToResult()
            ResultSimulation.SuccessSimulation(resultSimulation = resultMap)
        } catch (e: Exception) {
            ResultSimulation.ErrorSimulation(exception = e)
        }
    }
}