package com.example.quotes.domain.repository

import com.example.quotes.data.dto.QuotesDto
import com.example.quotes.data.dto.Result

interface QuotesRepository {
    suspend fun getQuotes(): QuotesDto
}