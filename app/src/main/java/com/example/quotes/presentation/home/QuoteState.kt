package com.example.quotes.presentation.home

import com.example.quotes.domain.models.Quote

data class QuoteState(
    val quotes: List<Quote> = emptyList(),
    val isLoading: Boolean = false,
    val error: String="",
    val searchQuery: String = ""
)
