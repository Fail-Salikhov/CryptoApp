package com.example.cryptoapp.domain

class GetCryptoItemUseCase(private val cryptoRepository: CryptoRepository) {

    fun getCryptoItem (cryptoItemId: Int) : CryptoItem {
        return cryptoRepository.getCryptoItem(cryptoItemId)
    }
}