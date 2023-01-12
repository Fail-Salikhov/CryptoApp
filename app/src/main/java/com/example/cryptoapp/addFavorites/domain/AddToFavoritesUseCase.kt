package com.example.cryptoapp.addFavorites.domain

import androidx.lifecycle.LiveData
import com.example.cryptoapp.addFavorites.data.database.FavoriteCoinDbModel
import javax.inject.Inject

class AddToFavoritesUseCase @Inject constructor(private val favoriteCoinRepository: FavoriteCoinRepository) {

     suspend operator fun invoke (fSym: String)  = favoriteCoinRepository.addToFavoriteUseCase(fSym)

}