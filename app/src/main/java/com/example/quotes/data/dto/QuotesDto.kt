package com.example.quotes.data.dto

import com.example.quotes.domain.models.Quote

data class QuotesDto(
    val count: Int,
    val lastItemIndex: Int,
    val page: Int,
    val results: List<Result>,
    val totalCount: Int,
    val totalPages: Int
)

fun QuotesDto.toQuote(): Quote{
return Quote(
    count,lastItemIndex, page, results, totalCount, totalPages
)
}