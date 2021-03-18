package com.example.easynvestapp.data.api

import com.example.easynvestapp.data.response.ServerResponse
import retrofit2.http.GET

interface ApiService {

    @GET("f6b23deb-b822-4d70-aaae-8523c3d84bf1")
    suspend fun getResult(): ServerResponse

}