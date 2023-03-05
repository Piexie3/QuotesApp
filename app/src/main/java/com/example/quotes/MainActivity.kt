package com.example.quotes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.quotes.presentation.home.HomeScreen
import com.example.quotes.presentation.home.HomeViewModel
import com.example.quotes.ui.theme.QuotesTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            QuotesTheme {
                val viewModel : HomeViewModel = hiltViewModel()
                Surface(
                   modifier = Modifier.fillMaxSize()
                ) {
                    HomeScreen(viewModel)
                }
            }
        }
    }
}
