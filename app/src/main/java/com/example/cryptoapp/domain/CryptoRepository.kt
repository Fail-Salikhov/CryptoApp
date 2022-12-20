package com.example.cryptoapp.domain

import androidx.lifecycle.LiveData

interface CryptoRepository {

<<<<<<< HEAD
    fun getCryptoItemListUseCase () : LiveData<List<CoinItem>>

    fun getCryptoItem (fromSymbol: String) : LiveData<CoinItem>

    suspend fun loadData()
=======
    fun getCryptoItemListUseCase () : LiveData<List<CryptoItem>>

    fun getCryptoItem (cryptoItemId: Int) : CryptoItem
>>>>>>> origin/master
}