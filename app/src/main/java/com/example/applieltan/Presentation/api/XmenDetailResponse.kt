package com.example.applieltan.Presentation.api

import java.net.HttpURLConnection

data class XmenDetailResponse(
        val name: String,
        val descriptions: List<XmenSlot>
)

data class XmenSlot(
    val slot: Int,
    val description: XmenDescription
)

data class XmenDescription(
        val name: String,
        val url: String

)