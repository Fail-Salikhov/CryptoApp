package com.example.cryptoapp.domain

import androidx.lifecycle.LiveData

class GetCryptoItemUseCase(private val cryptoRepository: CryptoRepository) {

    operator fun invoke (fromSymbol: String) = cryptoRepository.getCryptoItem(fromSymbol)
}