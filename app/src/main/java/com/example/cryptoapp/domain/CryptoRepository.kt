package com.example.cryptoapp.domain

import androidx.lifecycle.LiveData

interface CryptoRepository {

    fun getCryptoItemListUseCase () : LiveData<List<CryptoItem>>

    fun getCryptoItem (cryptoItemId: Int) : CryptoItem
}