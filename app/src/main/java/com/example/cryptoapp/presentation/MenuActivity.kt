package com.example.cryptoapp.presentation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.cryptoapp.databinding.ActivityMenuBinding
import com.example.cryptoapp.databinding.NavHiderMainBinding

class MenuActivity : AppCompatActivity() {

    private val binding  by lazy {
        ActivityMenuBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        val intent = Intent(this, CoinPriceListActivity::class.java)
        startActivity(intent)
    }
}