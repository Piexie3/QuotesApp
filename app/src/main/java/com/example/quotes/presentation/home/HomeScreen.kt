package com.example.quotes.presentation.home

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.quotes.domain.models.Quote
import com.example.quotes.ui.theme.lightGreen

@Composable
fun HomeScreen(
    viewModel: HomeViewModel
) {
    val state = viewModel.quoteState.value
   Box() {
       LazyColumn(){
           items(state.quotes){quote->
               QuoteCard(
                   quote
               )
               Divider(
                   modifier = Modifier
                       .padding(horizontal = 16.dp)
               )
           }
       }
    }
}

@Composable
fun QuoteCard(
    quote: Quote
) {
    val selected by remember {
        mutableStateOf(false)
    }
    Box() {
        Card(
            border = BorderStroke(width = 2.dp, color = lightGreen),
            backgroundColor = MaterialTheme.colors.secondary,
            contentColor = MaterialTheme.colors.onSecondary
        ) {
             Column(
                 modifier = Modifier
             ){
                 Row(
                     verticalAlignment = Alignment.CenterVertically,
                     horizontalArrangement = Arrangement.Center
                 ){
                     Text(
                         text = quote.results.toString(),
                         fontSize = 16.sp,
                         fontWeight = FontWeight.Bold,
                         textAlign = TextAlign.Center
                     )
                 }
            }
        }
        Text(
            text = "~by ${quote.page}",
            fontFamily = FontFamily.Cursive,
            modifier = Modifier.align(Alignment.BottomEnd)
        )
        IconButton(onClick = { /*TODO*/ }) {
            Icon(
                imageVector = if (selected) Icons.Default.Favorite
                else Icons.Default.FavoriteBorder,
                contentDescription = "favourite",
                tint = Color.Red
            )
        }
    }
}

