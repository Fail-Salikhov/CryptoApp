package com.example.cryptoapp.domain

import androidx.lifecycle.LiveData

class GetCryptoItemListUseCase(private val cryptoRepository: CryptoRepository) {

    operator fun invoke() = cryptoRepository.getCryptoItemListUseCase()

}