package com.example.cryptoapp.domain

import javax.inject.Inject


class GetCryptoItemUseCase  @Inject constructor(private val cryptoRepository: CryptoRepository) {

    operator fun invoke (fromSymbol: String) = cryptoRepository.getCryptoItem(fromSymbol)

}