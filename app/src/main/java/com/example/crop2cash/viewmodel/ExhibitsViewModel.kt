package com.example.crop2cash.viewmodel

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.airbnb.lottie.compose.*
import com.example.crop2cash.R
import com.example.crop2cash.usecase.GetExhibitsUseCase
import com.example.crop2cash.utils.ExhibitsState
import com.example.crop2cash.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ExhibitsViewModel @Inject constructor(
    private val getExhibitsUseCase: GetExhibitsUseCase
) : ViewModel() {

    private val _state = mutableStateOf(ExhibitsState())
    val state : State<ExhibitsState> = _state

    init {
        getExhibits()
    }

    fun getExhibits(){
        viewModelScope.launch {

            _state.value = ExhibitsState(isLoading = true)

            when(val response = getExhibitsUseCase()){
                is Resource.Success -> {
                    _state.value = ExhibitsState(exhibits = response.data ?: emptyList())
                }

                is Resource.Error -> {
                    _state.value = ExhibitsState(error = response.message)
                }

                is Resource.Loading -> {
                    _state.value = ExhibitsState(isLoading = true)
                }
            }
        }
    }
}

