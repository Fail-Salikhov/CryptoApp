package com.example.cryptoapp.domain


import kotlinx.coroutines.flow.Flow

interface CryptoRepository {

    fun getCryptoItemListUseCase () : Flow<List<CoinItem>>

    fun getCryptoItem (fromSymbol: String) : Flow<CoinItem>

    fun loadData()
}