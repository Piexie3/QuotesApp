package com.example.quotes.domain.repository

import com.example.quotes.data.dto.QuotesDto

interface QuotesRepository {
    suspend fun getQuotes(): List<QuotesDto>
}