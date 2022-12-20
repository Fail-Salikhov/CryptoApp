package com.example.cryptoapp.domain



class GetCryptoItemUseCase(private val cryptoRepository: CryptoRepository) {

    operator fun invoke (fromSymbol: String) = cryptoRepository.getCryptoItem(fromSymbol)

}