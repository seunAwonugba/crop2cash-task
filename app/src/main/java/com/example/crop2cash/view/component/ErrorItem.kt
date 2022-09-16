package com.example.crop2cash.view.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun ErrorItem(
    errorMessage: String,
    errorInstruction: String,
    retry: () -> Unit
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = errorMessage,
            textAlign = TextAlign.Center,
            color = MaterialTheme.colors.error
        )

        Text(
            text = errorInstruction,
            modifier = Modifier
                .clickable { retry() }
                .padding(vertical = 8.dp, horizontal = 16.dp),
            color = MaterialTheme.colors.primary
        )
    }
}