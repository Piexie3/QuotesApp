package com.example.quotes.domain.models

import com.example.quotes.data.dto.Result

data class Quote(
    val count: Int,
    val lastItemIndex: Int,
    val page: Int,
    val results: List<Result>,
    val totalCount: Int,
    val totalPages: Int
)
