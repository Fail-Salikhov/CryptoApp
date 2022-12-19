package com.example.cryptoapp.data.mapper

import android.util.Log
import com.example.cryptoapp.data.database.CoinDbModel
import com.example.cryptoapp.domain.CoinItem
import com.google.gson.Gson
import pojo.CoinInfoData
import pojo.CoinInfoJsonContainerDTO
import pojo.CoinInfoDto
import pojo.CoinNamesListDto

class CoinMapper {

    fun mapDtoToDbModel(dto: CoinInfoDto) = CoinDbModel(
        fromsymbol = dto.fromsymbol,
        tosymbol = dto.tosymbol,
        price = dto.price,
        lastupdate = dto.lastupdate,
        highday = dto.highday,
        lowday = dto.lowday,
        lastmarket = dto.lastmarket,
        imageurl = dto.imageurl
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
        fromsymbol = dbModel.fromsymbol,
        tosymbol = dbModel.tosymbol,
        price = dbModel.price,
        lastupdate = dbModel.lastupdate,
        highday= dbModel.highday,
        lowday = dbModel.lowday,
        lastmarket = dbModel.lastmarket,
        imageurl = dbModel.imageurl
    )
}