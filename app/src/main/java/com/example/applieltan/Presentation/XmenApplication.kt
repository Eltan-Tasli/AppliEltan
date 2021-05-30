package com.example.applieltan.Presentation

import android.app.Application
import android.content.Context

class XmenApplication : Application() {

    companion object{
        var context: Context? = null
    }

    override fun onCreate() {
        super.onCreate()
        context = this
    }

}