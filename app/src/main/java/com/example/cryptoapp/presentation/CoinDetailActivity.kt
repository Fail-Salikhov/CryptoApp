package com.example.cryptoapp

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.cryptoapp.data.network.ApiFactory.BASE_URL_IMAGE
import com.example.cryptoapp.databinding.ActivityCoinDetailBinding
import com.example.cryptoapp.utils.convertTimestampToTime
import com.squareup.picasso.Picasso

class CoinDetailActivity : AppCompatActivity() {

    private lateinit var viewModel: CoinViewModel

    private val binding by lazy { ActivityCoinDetailBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        if (!intent.hasExtra(EXTRA_FROM_SYMBOL)) {
            finish()
            return
        }
        val fromSymbol = intent.getStringExtra(EXTRA_FROM_SYMBOL) ?: EMPTY_FROM_SYMBOL
        viewModel = ViewModelProvider(this)[CoinViewModel::class.java]
        viewModel.getDetailInfo(fromSymbol).observe(this, Observer { it ->
            binding.tvPrice.text = it.price
            binding.tvMinPrice.text = it.lowday
            binding.tvMaxPrice.text = it.highday
            binding.tvLastMarket.text = it.lastmarket
            binding.tvLastUpdate.text = convertTimestampToTime(it.lastupdate)
            binding.tvFromSymbol.text = it.fromsymbol
            binding.tvToSymbol.text = it.tosymbol
            Picasso.get().load(BASE_URL_IMAGE + it.imageurl).into(binding.ivLogoCoin)
            Log.d("testdetail", it.toString())
        })

    }

    companion object {
        const val EXTRA_FROM_SYMBOL = "fSym"
        private const val EMPTY_FROM_SYMBOL = ""

        fun newIntent(context: Context, fromSymbol: String): Intent {
            val intent = Intent(context, CoinDetailActivity::class.java)
            intent.putExtra(EXTRA_FROM_SYMBOL, fromSymbol)
            return intent
        }
    }
}