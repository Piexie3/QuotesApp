package com.example.quotes.presentation.home

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.quotes.core.utils.Resource
import com.example.quotes.domain.use_cases.GetQuotesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject


@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getQuotesUseCase: GetQuotesUseCase
) : ViewModel() {

    private val _quoteState = mutableStateOf(QuoteState())
    val quoteState: State<QuoteState> = _quoteState

    init{
        getQuotes()
    }

    private  fun getQuotes(){
        getQuotesUseCase().onEach { result->
            when (result) {
                is Resource.Success -> {
                    _quoteState.value=QuoteState(quotes = result.data?: emptyList())
                }
                is Resource.Error->{
                    _quoteState.value=QuoteState(error= result.message?:
                    "An unexpected error occurred"
                    )

                }
                is Resource.Loading->{
                    _quoteState.value= QuoteState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }

}