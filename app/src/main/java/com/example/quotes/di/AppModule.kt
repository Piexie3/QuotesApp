package com.example.quotes.di

import com.example.quotes.core.utils.Constants.BASE_URL
import com.example.quotes.data.remote.QuoteApi
import com.example.quotes.data.repository.QuoteRepositoryImpl
import com.example.quotes.domain.repository.QuotesRepository
import com.example.quotes.domain.use_cases.GetQuotesUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun providesQuotesRepository(api: QuoteApi): QuotesRepository{
        return QuoteRepositoryImpl(api)
    }

    @Provides
    @Singleton
    fun providesQuoteApi(): QuoteApi{
        return Retrofit
            .Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(QuoteApi::class.java)
    }

    @Provides
    @Singleton
    fun providesGetQuotesUseCases(repository: QuotesRepository): GetQuotesUseCase{
        return GetQuotesUseCase(repository)
    }
}