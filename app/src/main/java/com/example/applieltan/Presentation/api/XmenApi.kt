package com.example.applieltan.Presentation.api

import retrofit2.Call
import retrofit2.http.GET

interface XmenApi {
    @GET("/api/characters")
    fun getXmenList(): Call<XmenResponse>
}