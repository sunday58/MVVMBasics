package com.sunday.mvvmbasics.utilities

import com.sunday.mvvmbasics.data.FakeDatabase
import com.sunday.mvvmbasics.data.QuoteRepository
import com.sunday.mvvmbasics.ui.quotes.QuotesViewModelFactory

object InjectorUtils {

    fun provideQuotesViewModelFactory(): QuotesViewModelFactory {
        val quoteRepository = QuoteRepository.getInstance(FakeDatabase.getInstance().quoteDao)
        return QuotesViewModelFactory(quoteRepository)
    }
}