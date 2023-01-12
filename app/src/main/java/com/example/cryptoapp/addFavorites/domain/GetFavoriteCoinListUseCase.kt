package com.example.cryptoapp.addFavorites.domain

import javax.inject.Inject

class GetFavoriteCoinListUseCase @Inject constructor(private val favoriteCoinRepository: FavoriteCoinRepository) {

    operator fun invoke() = favoriteCoinRepository.getFavoriteCoinListUseCase()
}