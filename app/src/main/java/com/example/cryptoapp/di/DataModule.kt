package com.example.cryptoapp.di

import android.app.Application
import com.example.cryptoapp.data.network.ApiFactory
import com.example.cryptoapp.data.network.ApiService
import com.example.cryptoapp.data.repositori.CryptoRepositoryImpl
import com.example.cryptoapp.domain.CryptoRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import databasw.AppDataBase
import databasw.CoinInfoDao

@Module
interface DataModule {

    @Binds
    @ApplicationScope
    fun bindCryptoRepository (impl: CryptoRepositoryImpl): CryptoRepository

    companion object {

        @Provides
        @ApplicationScope
        fun provideCoinInfoDao (application: Application) : CoinInfoDao {
            return AppDataBase.getInstance(application).coinPriceInfoDao()
        }

        @Provides
        @ApplicationScope
        fun provideApiService (): ApiService {
            return ApiFactory.apiService
        }
    }
}