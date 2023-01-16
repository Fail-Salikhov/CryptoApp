package com.example.cryptoapp.presentation

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
    }
}