package com.example.cryptoapp.data.mapper

import android.util.Log
import com.example.cryptoapp.addFavorites.data.database.FavoriteCoinDbModel
import com.example.cryptoapp.data.database.CoinDbModel
import com.example.cryptoapp.domain.CoinItem
import com.google.gson.Gson
import pojo.CoinInfoJsonContainerDTO
import pojo.CoinInfoDto
import pojo.CoinNamesListDto
import java.sql.Timestamp
import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Inject

class CoinMapper @Inject constructor() {

    fun mapDtoToDbModel(dto: CoinInfoDto) = CoinDbModel(
        fromSymbol = dto.fromSymbol,
        toSymbol = dto.toSymbol,
        price = dto.price,
        lastUpdate = dto.lastUpdate,
        highDay = dto.highDay,
        lowDay = dto.lowDay,
        lastMarket = dto.lastMarket,
        imageUrl = BASE_URL_IMAGE + dto.imageUrl
    )

    fun mapJsonContainerToListCoinInfo (jsonContainerDTO: CoinInfoJsonContainerDTO) : List<CoinInfoDto> {
        val result = mutableListOf<CoinInfoDto>()
        Log.d("test", result.toString())
        val jasonObject = jsonContainerDTO.jsonObject ?: return result
        val coinKeySet = jasonObject.keySet()
        for (coinKey in coinKeySet) {
            val currencyJson = jasonObject.getAsJsonObject(coinKey)
            val currencyKeySet = currencyJson.keySet()
            for (currencyKey in currencyKeySet) {
                val praiceInfo =
                    Gson().fromJson(currencyJson.getAsJsonObject(currencyKey), CoinInfoDto::class.java)
                result.add(praiceInfo)
            }
        }
        return result
    }

    fun mapNamesListToString (coinNamesListDto: CoinNamesListDto) : String {
      return coinNamesListDto.names?.map { it.coinName?.name }?.joinToString(",") ?: ""
    }

    fun mapDbModelToEntity (dbModel: CoinDbModel) = CoinItem (
        fromsymbol = dbModel.fromSymbol,
        tosymbol = dbModel.toSymbol,
        price = dbModel.price,
        lastupdate = convertTimestampToTime(dbModel.lastUpdate),
        highday = dbModel.highDay,
        lowday = dbModel.lowDay,
        lastmarket = dbModel.lastMarket,
        imageurl = dbModel.imageUrl
    )

    private  fun convertTimestampToTime(timestamp: Long?): String {
        if (timestamp == null) return ""
        val stamp = Timestamp(timestamp * 1000)
        val date = Date(stamp.time)
        val pattern = "HH:mm:ss"
        val sdf = SimpleDateFormat(pattern, Locale.getDefault())
        sdf.timeZone = TimeZone.getDefault()
        return sdf.format(date)
    }

    fun mapDbModelToFavoriteDb (dbModel: CoinDbModel) = FavoriteCoinDbModel (
        fromSymbol = dbModel.fromSymbol,
        toSymbol = dbModel.toSymbol,
        price = dbModel.price,
        lastUpdate = dbModel.lastUpdate,
        highDay = dbModel.highDay,
        lowDay = dbModel.lowDay,
        lastMarket = dbModel.lastMarket,
        imageUrl = dbModel.imageUrl
    )

    fun mapFavoriteDbModelToEntity (favoriteDbModel: FavoriteCoinDbModel) = CoinItem (
        fromsymbol = favoriteDbModel.fromSymbol,
        tosymbol = favoriteDbModel.toSymbol,
        price = favoriteDbModel.price,
        lastupdate = convertTimestampToTime(favoriteDbModel.lastUpdate),
        highday = favoriteDbModel.highDay,
        lowday = favoriteDbModel.lowDay,
        lastmarket = favoriteDbModel.lastMarket,
        imageurl = favoriteDbModel.imageUrl
    )

    companion object {
        const val BASE_URL_IMAGE = "https://cryptocompare.com"
    }
}