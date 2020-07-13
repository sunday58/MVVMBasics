package com.sunday.mvvmbasics.ui.quotes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.sunday.mvvmbasics.R
import com.sunday.mvvmbasics.data.Quote
import com.sunday.mvvmbasics.utilities.InjectorUtils
import kotlinx.android.synthetic.main.activity_quotes.*
import java.lang.StringBuilder

class QuotesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quotes)
        initializedUi()
    }

    private fun initializedUi(){
        val factory = InjectorUtils.provideQuotesViewModelFactory()
        val viewModel = ViewModelProvider(this, factory)
            .get(QuotesViewModel::class.java)

        viewModel.getQuotes().observe(this, Observer {quotes ->
            val stringBuilder = StringBuilder()
            quotes.forEach {  quote ->
                stringBuilder.append("$quote\n\n")
                textView_quotes.text = stringBuilder.toString()
            }
        })
        add_quote.setOnClickListener {
            val quote = Quote(editTest_quotes.text.toString(), editTest_author.text.toString())
            viewModel.addQuote(quote)
            editTest_quotes.setText("")
            editTest_author.setText("")
        }
    }
}