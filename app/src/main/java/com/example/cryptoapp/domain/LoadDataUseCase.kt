package com.example.cryptoapp.domain

import javax.inject.Inject

class LoadDataUseCase  @Inject constructor(private val cryptoRepository: CryptoRepository) {

    operator fun invoke() = cryptoRepository.loadData()
}