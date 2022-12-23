package com.example.cryptoapp.domain

import androidx.lifecycle.LiveData
import javax.inject.Inject

class GetCryptoItemListUseCase  @Inject constructor(private val cryptoRepository: CryptoRepository) {

    operator fun invoke() = cryptoRepository.getCryptoItemListUseCase()

}