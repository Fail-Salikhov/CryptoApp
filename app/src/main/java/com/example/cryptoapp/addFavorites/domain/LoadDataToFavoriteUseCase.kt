package com.example.cryptoapp.addFavorites.domain

import javax.inject.Inject

class LoadDataToFavoriteUseCase @Inject constructor(private val favoriteCoinRepository: FavoriteCoinRepository) {

    operator fun invoke() = favoriteCoinRepository.loaDataFavorite()
}