package com.example.applieltan.Presentation

import com.example.applieltan.Presentation.api.XmenApi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class Singletons {
    companion object {
        val xmenApi: XmenApi = Retrofit.Builder()
                .baseUrl("https://xmenapiheroku.herokuapp.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(XmenApi::class.java)
    }
}
