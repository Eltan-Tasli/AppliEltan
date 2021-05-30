package com.example.applieltan.Presentation

import com.example.applieltan.Presentation.XmenApplication.Companion.context
import com.example.applieltan.Presentation.api.XmenApi
import okhttp3.Cache
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.File


class Singletons {
    companion object {
        var cache = Cache(File(context?.cacheDir, "responses"), 10 * 1024 * 1024) // 10 MiB

        val okHttpClient: OkHttpClient = OkHttpClient().newBuilder()
            .cache(cache)
            .build()

        val xmenApi: XmenApi = Retrofit.Builder()
                .baseUrl("https://xmenapiheroku.herokuapp.com")
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build()
                .create(XmenApi::class.java)

    }
}
