package com.example.cryptoapp.addFavorites.domain

import javax.inject.Inject

class DeleteCoinFromFavoriteUseCase @Inject constructor(private val favoriteCoinRepository: FavoriteCoinRepository) {

    operator fun invoke (fromSymbol: String) = favoriteCoinRepository.deleteCoinFromFavorite(fromSymbol)
}