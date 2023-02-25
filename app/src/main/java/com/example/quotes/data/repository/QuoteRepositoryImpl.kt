package com.example.quotes.data.repository

import android.util.Log
import com.example.quotes.data.dto.QuotesDto
import com.example.quotes.data.remote.QuoteApi
import com.example.quotes.domain.repository.QuotesRepository
import javax.inject.Inject


class QuoteRepositoryImpl @Inject constructor(
    private val api: QuoteApi
): QuotesRepository{
   override suspend fun getQuotes(): List<QuotesDto> {
        return api.getAllQuotes()
    }
}