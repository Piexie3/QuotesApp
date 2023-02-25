package com.example.quotes.data.remote

import com.example.quotes.data.dto.QuotesDto
import retrofit2.http.GET

interface QuoteApi {
    @GET("quotes")
    suspend fun getAllQuotes(): List<QuotesDto>
}