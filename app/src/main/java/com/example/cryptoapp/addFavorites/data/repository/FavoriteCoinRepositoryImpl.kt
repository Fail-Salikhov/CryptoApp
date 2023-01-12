package com.example.cryptoapp.addFavorites.data.repository

import android.app.Application
import com.example.cryptoapp.addFavorites.data.database.FavoriteCoinDao
import com.example.cryptoapp.addFavorites.domain.FavoriteCoinRepository
import com.example.cryptoapp.data.mapper.CoinMapper
import com.example.cryptoapp.domain.CoinItem
import databasw.CoinInfoDao
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class FavoriteCoinRepositoryImpl @Inject constructor(
    private val favoriteCoinDao: FavoriteCoinDao,
    private val mapper : CoinMapper,
    private val coinInfoDao : CoinInfoDao,
) :  FavoriteCoinRepository{

     override suspend fun addToFavoriteUseCase(fSym: String){
         val coinDb = coinInfoDao.getCoinDbModel(fSym)
         favoriteCoinDao.addCoinToFavorite(mapper.mapDbModelToFavoriteDb(coinDb))
    }

    override suspend fun deleteCoinFromFavorite(fromSymbol: String) {
        favoriteCoinDao.deleteCoinFromFavorite(fromSymbol)
    }

    override fun getFavoriteCoinListUseCase(): Flow<List<CoinItem>> {
        return favoriteCoinDao.getFavoriteCoinList().map {
            it.map {
                mapper.mapFavoriteDbModelToEntity(it)
            }
        }
    }

    override fun loaDataFavorite() {
        TODO("Not yet implemented")
    }
}