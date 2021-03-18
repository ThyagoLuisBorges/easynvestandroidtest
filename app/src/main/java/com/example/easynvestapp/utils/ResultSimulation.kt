package com.example.easynvestapp.utils

import com.example.easynvestapp.data.model.Result
import java.lang.Exception

sealed class ResultSimulation {
    data class SuccessSimulation(val resultSimulation: Result) : ResultSimulation()
    data class ErrorSimulation(val exception: Exception) : ResultSimulation()
}
