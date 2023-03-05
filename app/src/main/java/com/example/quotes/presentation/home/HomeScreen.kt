package com.example.quotes.presentation.home

import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FilterVintage
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.quotes.core.composables.SearchBar
import com.example.quotes.presentation.home.composables.PostCard

@Composable
fun HomeScreen(
    viewModel: HomeViewModel
) {
    Scaffold(
        topBar = {
            TopApp()
        }
    ) { paddingValues ->
        val state = viewModel.quoteState.value
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = paddingValues.calculateTopPadding())
        ) {
            val lazyListState = rememberLazyListState()
            LazyColumn(
                modifier = Modifier.padding(horizontal = 5.dp),
                state = lazyListState
            ) {
                items(state.quotes) { quotes ->
                    PostCard(quotes)
                }
            }
            if (state.error.isNotBlank()) {
                Text(
                    text = state.error,
                    color = MaterialTheme.colors.error,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 20.dp)
                        .align(Alignment.Center)
                )
            }
            if (state.isLoading) {
                CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
            }
        }
    }
}


@Composable
fun TopApp() {
    Row(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Absolute.SpaceBetween
    ) {
        SearchBar(
            modifier = Modifier
                .clip(RoundedCornerShape(100))
                .fillMaxWidth(.80F),
            onSearchParamChange = {
                // TODO("Update value in viewModel")
            },
            onSearchClick = {
                // TODO("Perform search event")
            }
        )
        IconButton(
            onClick = { /*TODO*/ },
            modifier = Modifier
                .clip(CircleShape)
                .background(
                    if (isSystemInDarkTheme())
                        Color.White.copy(alpha = .24F) else
                        Color.Black.copy(alpha = .24F)
                )
        ) {
            Icon(
                imageVector = Icons.Default.FilterVintage,
                contentDescription = "Filter",
                tint = if (isSystemInDarkTheme())
                    Color.White else
                    Color.Black
            )
        }
    }
}
