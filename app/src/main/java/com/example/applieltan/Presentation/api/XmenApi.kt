package com.example.applieltan.Presentation.api

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface XmenApi {
    @GET("/api/characters")
    fun getXmenList(): Call<XmenCharactersResponse>

    @GET("/api/characters/{id}")
    fun getXmenDetail(@Path("id") id: String): Call<XmenDetailResponse>
}