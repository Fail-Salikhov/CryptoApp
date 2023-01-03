package com.example.cryptoapp.addFavorites.domain

import androidx.lifecycle.LiveData
import com.example.cryptoapp.addFavorites.data.database.FavoriteCoinDbModel
import com.example.cryptoapp.domain.CoinItem

interface FavoriteCoinRepository {

    suspend fun addToFavoriteUseCase (fSym: String)

    suspend fun deleteCoinFromFavorite (fromSymbol: String)

    fun getFavoriteCoinListUseCase () : LiveData<List<CoinItem>>

    fun loaDataFavorite ()
}