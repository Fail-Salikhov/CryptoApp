package com.example.cryptoapp.data.repositori

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import androidx.work.ExistingWorkPolicy
import androidx.work.WorkManager
import com.example.cryptoapp.data.mapper.CoinMapper
import com.example.cryptoapp.data.network.workers.RefreshDataWorker
import com.example.cryptoapp.domain.CoinItem
import com.example.cryptoapp.domain.CryptoRepository
import databasw.AppDataBase
import databasw.CoinInfoDao
import kotlinx.coroutines.delay
import javax.inject.Inject

class CryptoRepositoryImpl  @Inject constructor (
    private val coinInfoDao : CoinInfoDao,
    private val mapper : CoinMapper,
    private val application: Application
    ) : CryptoRepository {




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

    override fun loadData() {
        val workManager = WorkManager.getInstance(application)
        workManager.enqueueUniqueWork(
            RefreshDataWorker.NAME,
            ExistingWorkPolicy.REPLACE,
            RefreshDataWorker.makeRequest()
        )
    }
}