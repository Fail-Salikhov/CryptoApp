package com.example.cryptoapp.addFavorites.data.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.cryptoapp.data.database.CoinDbModel

@Dao
interface FavoriteCoinDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addCoinToFavorite (favoriteCoinDbModel: FavoriteCoinDbModel)

    @Query("SELECT * FROM favorite_coin ORDER BY lastUpdate")
    fun getFavoriteCoinList () : LiveData<List<FavoriteCoinDbModel>>

    @Query("SELECT * FROM favorite_coin WHERE fromsymbol == :fSym LIMIT 1")
    fun getPriceInfoAboutCoin (fSym: String) : LiveData<FavoriteCoinDbModel>

    @Query("DELETE FROM favorite_coin WHERE fromSymbol=:fSym")
    suspend fun deleteCoinFromFavorite (fSym: String)
}