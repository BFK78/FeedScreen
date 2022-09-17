package com.example.feedpage.presentation.charcha.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp

@Composable
fun FeedAction(
    modifier: Modifier = Modifier,
    icon: Painter,
    value: String,
    text: String,
    isSelected: Boolean = false,
    onClick: () -> Unit
) {

    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        IconButton(
            onClick = { onClick() },
            modifier = Modifier.then(Modifier.size(24.dp))
        ) {
            Icon(
                painter = icon,
                contentDescription = "action icon",
                tint = if (isSelected) Color.Red else Color.Black
            )
        }

        Spacer(modifier = Modifier.width(8.dp))

        Text(text = value)

        Spacer(modifier = Modifier.width(2.dp))

        Text(text = text)

    }

}