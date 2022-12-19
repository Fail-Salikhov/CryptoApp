package com.example.cryptoapp.domain

import androidx.lifecycle.LiveData

class GetCryptoItemListUseCase(private val cryptoRepository: CryptoRepository) {

    fun getCryptoItemListUseCase () : LiveData<List<CryptoItem>> {
        return cryptoRepository.getCryptoItemListUseCase()
    }
}