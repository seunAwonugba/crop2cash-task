package com.example.crop2cash.view.component

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.crop2cash.view.model.Exhibit
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.HorizontalPagerIndicator
import com.google.accompanist.pager.rememberPagerState


@OptIn(ExperimentalPagerApi::class)
@Composable
fun ExhibitListItem(
    exhibit : Exhibit,
){
    val imageList = exhibit.images
    val pagerState = rememberPagerState()

    Card(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        elevation = 8.dp,
        shape = RoundedCornerShape(16.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Text(text = exhibit.title, fontSize = 24.sp)

            Spacer(modifier = Modifier.height(16.dp))

            Box(modifier = Modifier.fillMaxSize()) {

                Column {
                    HorizontalPager(
                        count = imageList.size,
                        state = pagerState,
                    ) { page ->
                        ExhibitImageView(exhibitImage = imageList[page])
                    }

                    Box(contentAlignment = Alignment.BottomCenter, modifier = Modifier.fillMaxWidth()){
                        HorizontalPagerIndicator(
                            pagerState = pagerState,
                            modifier = Modifier
                                .padding(16.dp)
                                .align(Alignment.Center)
                        )
                    }
                }
            }
        }
    }
}

