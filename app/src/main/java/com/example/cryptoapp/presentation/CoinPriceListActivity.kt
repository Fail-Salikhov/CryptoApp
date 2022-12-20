package com.example.cryptoapp.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.cryptoapp.CoinDetailActivity
import com.example.cryptoapp.CoinViewModel
import com.example.cryptoapp.R
import com.example.cryptoapp.databinding.ActivityMainBinding
import com.example.cryptoapp.domain.CoinItem
import com.example.cryptoapp.presentation.adapter.CoinInfoAdapter

class CoinPriceListActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    private lateinit var viewModel : CoinViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        val adapter = CoinInfoAdapter(this)
        adapter.onCoinClickListener = object : CoinInfoAdapter.OnCoinClickListener{
            override fun onCoinClick(coinItem: CoinItem) {
                val intent = CoinDetailActivity.newIntent(this@CoinPriceListActivity, coinItem.fromsymbol)
                startActivity(intent)
            }
        }
        val rvCoinList = binding.rvCoinPriceList
        rvCoinList.adapter = adapter
        viewModel = ViewModelProvider(this)[CoinViewModel::class.java]
        viewModel.coinInfoList.observe(this, Observer {
            adapter.submitList(it)
            Log.d("test", it.toString())
        })
    }
}