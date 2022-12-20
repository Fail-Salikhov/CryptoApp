package com.example.cryptoapp.domain

import androidx.lifecycle.LiveData

interface CryptoRepository {

    fun getCryptoItemListUseCase () : LiveData<List<CoinItem>>

    fun getCryptoItem (fromSymbol: String) : LiveData<CoinItem>

    fun loadData()
}