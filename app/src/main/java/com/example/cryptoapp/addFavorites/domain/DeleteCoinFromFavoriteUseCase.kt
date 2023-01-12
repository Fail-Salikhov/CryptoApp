package com.example.cryptoapp.addFavorites.domain

import javax.inject.Inject

class DeleteCoinFromFavoriteUseCase @Inject constructor(private val favoriteCoinRepository: FavoriteCoinRepository) {

    suspend operator fun invoke (fromSymbol: String) = favoriteCoinRepository.deleteCoinFromFavorite(fromSymbol)
}