package com.example.quotes.domain.use_cases

import com.example.quotes.core.utils.Resource
import com.example.quotes.data.dto.toQuote
import com.example.quotes.domain.models.Quote
import com.example.quotes.domain.repository.QuotesRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetQuotesUseCase @Inject constructor(
    private val repository: QuotesRepository
) {

    operator fun invoke(): Flow<Resource<List<Quote>>> = flow{
        try{
            emit(Resource.Loading())
            val quotes = repository.getQuotes().map { it.toQuote() }
            emit(Resource.Success(quotes))
        }catch(e: HttpException){
            emit(Resource.Error(e.localizedMessage?: "An  unexpected Error occurred!"))
        }catch(e: IOException){
            emit(Resource.Error(e.localizedMessage?: "Couldn't reach server. Please check your Internet Connections"))
        }catch(e: Exception){
            emit(Resource.Error(e.localizedMessage?: "an Error has occurred"))
        }
    }
}