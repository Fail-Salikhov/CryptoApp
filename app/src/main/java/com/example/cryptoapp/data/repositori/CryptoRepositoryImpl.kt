package com.example.cryptoapp.data.repositori

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.example.cryptoapp.data.mapper.CoinMapper
import com.example.cryptoapp.data.network.ApiFactory
import com.example.cryptoapp.data.network.ApiService
import com.example.cryptoapp.domain.CoinItem
import com.example.cryptoapp.domain.CryptoRepository
import databasw.AppDataBase
import kotlinx.coroutines.delay

class CryptoRepositoryImpl(application: Application) : CryptoRepository {

    private val coinInfoDao = AppDataBase.getInstance(application).coinPriceInfoDao()

    private val mapper = CoinMapper()
    private val apiService = ApiFactory.apiService


    override fun getCryptoItemListUseCase(): LiveData<List<CoinItem>> {
       return Transformations.map(coinInfoDao.getPriceList()){
           it.map {
               mapper.mapDbModelToEntity(it)
           }
       }
    }


    override fun getCryptoItem(fromSymbol: String): LiveData<CoinItem> {
        return Transformations.map(coinInfoDao.getPriceInfoAboutCoin(fromSymbol)){
            mapper.mapDbModelToEntity(it)
        }
    }

    override suspend fun loadData() {
        while (true) {
            try {
                val topCoins = apiService.getTopCoinsInfo(limit = 50)
                val fSyms = mapper.mapNamesListToString(topCoins)
                val json = apiService.getFullPriceListJSON(fSyms)
                val coinInfoListDto = mapper.mapJsonContainerToListCoinInfo(json)
                val coinIfoDbList = coinInfoListDto.map { mapper.mapDtoToDbModel(it) }
                coinInfoDao.insertPriseList(coinIfoDbList)
            } catch (e: Exception) {
            }
            delay(10000)
        }
    }
}