package com.example.quotes.data.remote

import com.example.quotes.data.dto.QuotesDto
import com.example.quotes.data.dto.Result
import retrofit2.http.GET

interface QuoteApi {
    @GET("quotes")
    suspend fun getAllQuotes(): QuotesDto
}