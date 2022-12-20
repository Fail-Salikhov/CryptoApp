package com.example.cryptoapp.domain

class LoadDataUseCase (private val cryptoRepository: CryptoRepository) {

    operator fun invoke() = cryptoRepository.loadData()
}