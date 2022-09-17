package com.example.feedpage.presentation.charcha.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.feedpage.R

@Composable
fun FeedProfile(
    modifier: Modifier = Modifier,
    painter: Painter,
    name: String,
    lastOnline: String,
    postType: String


) {

    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 24.dp, horizontal = 16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        Row {

            Image(
                painter = painter,
                contentDescription = "profile picture",
                modifier = Modifier
                    .size(50.dp)
                    .clip(shape = CircleShape)
            )

            Spacer(modifier = Modifier.width(12.dp))

            Column(
                modifier = Modifier,
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = name,
                    fontWeight = FontWeight.Bold
                )
                
                Spacer(modifier = Modifier.height(4.dp))

                Text(
                    text = "$lastOnline hours ago",
                    fontSize = 12.sp,
                    color = Color.Black.copy(
                        alpha = 0.5f
                    )
                )
            }
             Spacer(modifier = Modifier.width(8.dp))

            Text(
                text = postType,
                modifier = Modifier
                    .background(color = MaterialTheme.colors.primary.copy(
                        alpha = 0.1f
                    ))
                    .padding(horizontal = 4.dp, vertical = 2.dp)
                    ,
                color = MaterialTheme.colors.primary,
                fontSize = 14.sp
                )
        }

        IconButton(onClick = { /*TODO*/ }) {
            Icon(painter = painterResource(id = R.drawable.ic_more), contentDescription = "More icon")
        }

    }

}