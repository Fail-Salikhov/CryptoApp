package com.example.cryptoapp.domain

import androidx.lifecycle.LiveData

class GetCryptoItemListUseCase(private val cryptoRepository: CryptoRepository) {

<<<<<<< HEAD
    operator fun invoke() = cryptoRepository.getCryptoItemListUseCase()
=======
    fun getCryptoItemListUseCase () : LiveData<List<CryptoItem>> {
        return cryptoRepository.getCryptoItemListUseCase()
    }
>>>>>>> origin/master
}