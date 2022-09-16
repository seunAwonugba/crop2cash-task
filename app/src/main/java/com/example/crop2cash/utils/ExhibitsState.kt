package com.example.crop2cash.utils

import com.example.crop2cash.view.model.Exhibit

data class ExhibitsState(
    val isLoading : Boolean = false,
    val exhibits : List<Exhibit> = emptyList(),
    val error: Throwable? = null
)

