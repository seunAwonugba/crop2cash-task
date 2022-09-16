package com.example.crop2cash.view.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.annotation.ExperimentalCoilApi
import coil.compose.ImagePainter
import coil.compose.rememberImagePainter
import com.example.crop2cash.R

@OptIn(ExperimentalCoilApi::class)
@Composable
fun ExhibitImageView(exhibitImage : String) {

    val painter = rememberImagePainter(data = exhibitImage){
        placeholder(R.drawable.placeholder)
        crossfade(2000)
        error(R.drawable.picture_loading_failed_1)
    }

    val painterState = painter.state

    Column {
        Image(
            painter = painter,
            contentDescription = "",
            contentScale = ContentScale.Crop,
            modifier = Modifier.height(300.dp).clip(RoundedCornerShape(16.dp))
        )

        if (painterState is ImagePainter.State.Loading) {
            CircularProgressIndicator(
                color = MaterialTheme.colors.primary, modifier = Modifier.scale(.5f))
        }
    }
}