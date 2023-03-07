package com.example.quotes.presentation.home

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.quotes.core.utils.Resource
import com.example.quotes.domain.use_cases.GetQuotesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getQuotesUseCase: GetQuotesUseCase
) : ViewModel() {

    private val _quoteState = mutableStateOf(QuoteState())
    val quoteState: State<QuoteState> = _quoteState

    private var _searchState = mutableStateOf(QuoteState())
    val searchState: State<QuoteState> = _searchState

    var searchParam = mutableStateOf("")
    var previousSearch = mutableStateOf("")
    var searchParamState: State<String> = searchParam


    init {
        getQuotes()
    }

    private fun getQuotes() {
        getQuotesUseCase().onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _quoteState.value = QuoteState(quotes = result.data ?: emptyList())
                }
                is Resource.Error -> {
                    _quoteState.value = QuoteState(
                        error = result.message ?: "An unexpected error occurred"
                    )

                }
                is Resource.Loading -> {
                    _quoteState.value = QuoteState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }


    init {
        searchQuotes(query = searchParam.value)
    }

    private fun searchQuotes(query: String) {
        viewModelScope.launch {
            getQuotesUseCase().onEach { result ->
                when(result){
                    is Resource.Success ->{
                       val newList = _searchState.value.searchQuotes?.filter {
                           it.author.contains(query, ignoreCase = true)
                       }
                        _searchState.value = _searchState.value.copy(
                            searchQuotes = newList
                        )
                    }
                    is Resource.Error -> TODO()
                    is Resource.Loading -> TODO()
                }
            }
        }
    }
}

