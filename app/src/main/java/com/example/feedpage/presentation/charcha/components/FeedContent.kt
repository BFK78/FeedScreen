package com.example.feedpage.presentation.charcha.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import com.example.feedpage.R
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager

@OptIn(ExperimentalPagerApi::class, ExperimentalCoilApi::class)
@Composable
fun FeedContent(
    modifier: Modifier = Modifier,
    text: String,
    content: List<String>,
) {

    Column(
        modifier = modifier
    ) {

        Text(
            text = text,
            fontSize =  16.sp
        )
         Spacer(modifier = Modifier.height(16.dp))

        HorizontalPager(
            count = content.size,
            itemSpacing = 8.dp,
            contentPadding = PaddingValues(end = 24.dp)
        ) { page ->
            val imagePainter = rememberImagePainter(data = content[page])

            Column {
                Image(
                    painter = imagePainter,
                    contentDescription = "",
                    modifier = Modifier
                        .height(400.dp)
                        .clip(RoundedCornerShape(15.dp)),
                    contentScale = ContentScale.Crop
                )



            }
        }

    }

}