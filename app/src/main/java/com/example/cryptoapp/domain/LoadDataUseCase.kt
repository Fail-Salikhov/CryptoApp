package com.example.cryptoapp.domain

class LoadDataUseCase (private val cryptoRepository: CryptoRepository) {

    suspend operator fun invoke() = cryptoRepository.loadData()
}