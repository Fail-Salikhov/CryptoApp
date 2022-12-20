package com.example.cryptoapp.domain

<<<<<<< HEAD
import androidx.lifecycle.LiveData

class GetCryptoItemUseCase(private val cryptoRepository: CryptoRepository) {

    operator fun invoke (fromSymbol: String) = cryptoRepository.getCryptoItem(fromSymbol)
=======
class GetCryptoItemUseCase(private val cryptoRepository: CryptoRepository) {

    fun getCryptoItem (cryptoItemId: Int) : CryptoItem {
        return cryptoRepository.getCryptoItem(cryptoItemId)
    }
>>>>>>> origin/master
}