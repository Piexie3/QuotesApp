package com.example.quotes.presentation.home.composables

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.quotes.R
import kotlin.random.Random

@Composable
fun ProfileImage() {

    Box(
        modifier = Modifier
            .clip(CircleShape)
            .size(48.dp)
            .border(
                width = 2.dp,
                color = Color.Cyan,
                shape = CircleShape
            )
            .padding(2.dp)
            .clickable {

            }

    ) {
        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data("https://picsum.photos/seed/${Random.nextInt()}/300/200")
                .crossfade(true)
                .placeholder(R.drawable.profile)
                .build(),
            contentDescription = "Profile Image",
            modifier = Modifier
                .aspectRatio(1f, matchHeightConstraintsFirst = true)
                .border(
                    width = 1.dp,
                    color = Color.LightGray,
                    shape = CircleShape
                )
                .padding(3.dp)
                .clip(CircleShape),
            alignment = Alignment.Center,
            contentScale = ContentScale.Crop,
            fallback = painterResource(id = R.drawable.placeholder)
        )

    }

}
