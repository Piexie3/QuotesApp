package com.example.quotes.data.dto
import com.example.quotes.domain.models.Quotes

data class QuotesDto(
    val count: Int,
    val lastItemIndex: Int,
    val page: Int,
    val results: List<Result>,
    val totalCount: Int,
    val totalPages: Int
)

fun QuotesDto.toQuotes(): List<Quotes>{
   return results.map { result->
       Quotes(
           _id = result._id,
           author = result.author,
           authorSlug = result.authorSlug,
           content = result.content,
           dateAdded = result.dateAdded,
           dateModified = result.dateModified,
           length = result.length,
           tags = result.tags
       )
   }
}

