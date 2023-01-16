package com.example.cryptoapp.data.repositori

import android.app.Application
import androidx.work.ExistingWorkPolicy
import androidx.work.WorkManager
import com.example.cryptoapp.data.mapper.CoinMapper
import com.example.cryptoapp.data.network.workers.RefreshDataWorker
import com.example.cryptoapp.domain.CoinItem
import com.example.cryptoapp.domain.CryptoRepository
import databasw.CoinInfoDao
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class CryptoRepositoryImpl  @Inject constructor (
    private val coinInfoDao : CoinInfoDao,
    private val mapper : CoinMapper,
    private val application: Application
    ) : CryptoRepository {




    override fun getCryptoItemListUseCase(): Flow<List<CoinItem>> {
       return coinInfoDao.getPriceList().map{
           it.map {
               mapper.mapDbModelToEntity(it)
           }
       }
    }


    override fun getCryptoItem(fromSymbol: String): Flow<CoinItem> {
        return coinInfoDao.getPriceInfoAboutCoin(fromSymbol).map{
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