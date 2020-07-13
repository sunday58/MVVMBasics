package com.sunday.mvvmbasics.ui.quotes

import androidx.lifecycle.ViewModel
import com.sunday.mvvmbasics.data.Quote
import com.sunday.mvvmbasics.data.QuoteRepository

class QuotesViewModel(private val quoteRepository: QuoteRepository )
    :ViewModel(){

    fun getQuotes() = quoteRepository.getQuotes()

    fun addQuote(quote:Quote) = quoteRepository.addQuote(quote)
}