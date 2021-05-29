package com.example.applieltan.Presentation.api

import com.example.applieltan.Presentation.list.Xmen

data class XmenCharactersResponse(
    val count: Int,
    val next: String,
    val results: List<Xmen>
)