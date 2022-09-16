package com.example.crop2cash.view

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.crop2cash.R
import com.example.crop2cash.view.component.ErrorItem
import com.example.crop2cash.view.component.ExhibitListItem
import com.example.crop2cash.view.component.LottieLoader
import com.example.crop2cash.viewmodel.ExhibitsViewModel

@Composable
fun ExhibitsScreen(
    viewModel : ExhibitsViewModel = hiltViewModel(),
){

    val state = viewModel.state.value
    val err = state.error

    when{
        state.isLoading -> {
            Box(modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ){
                LottieLoader()
            }
        }

        state.error?.message?.isNotEmpty() == true -> {
            Box(contentAlignment = Alignment.Center) {
                when{
                    err?.message?.contains(stringResource(id = R.string.unable_to_resolve_host)) == true -> {
                        ErrorItem(
                            errorMessage = stringResource(id = R.string.lost_internet_connection),
                            errorInstruction = stringResource(id = R.string.click_to_retry)
                        ) { viewModel.getExhibits()}
                    }
                    err?.message?.contains(stringResource(id = R.string.http_404)) == true -> {
                        ErrorItem(
                            errorMessage = stringResource(id = R.string.resource_not_found),
                            errorInstruction = stringResource(id = R.string.click_to_go_back)
                        ) { viewModel.getExhibits() }
                    }
                    else -> {
                        ErrorItem(
                            errorMessage = stringResource(id = R.string.unknown_error),
                            errorInstruction = stringResource(id = R.string.click_to_retry)
                        ) { viewModel.getExhibits() }
                    }
                }

            }
        }

        else -> {
            Column {
                Text(
                    text = "Crop2Cash Assessment",
                    fontSize = 24.sp,
                    modifier = Modifier.padding(16.dp)
                )
                LazyColumn(modifier = Modifier.fillMaxSize()) {
                    items(state.exhibits){ item ->
                        ExhibitListItem(exhibit = item)
                    }
                }
            }
        }
    }

}