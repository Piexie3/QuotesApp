package com.example.quotes.presentation.home


import com.example.quotes.domain.models.Quotes

data class QuoteState(
    val quotes: List<Quotes> = emptyList(),
    val searchQuotes: List<Quotes>? = quotes,
    val isLoading: Boolean = false,
    val error: String="",
    val searchQuery: String = ""
)
