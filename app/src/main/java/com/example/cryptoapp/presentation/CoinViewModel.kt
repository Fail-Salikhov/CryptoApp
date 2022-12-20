package com.example.cryptoapp

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.cryptoapp.data.repositori.CryptoRepositoryImpl
import com.example.cryptoapp.domain.GetCryptoItemListUseCase
import com.example.cryptoapp.domain.GetCryptoItemUseCase
import com.example.cryptoapp.domain.LoadDataUseCase
import kotlinx.coroutines.launch

class CoinViewModel(application: Application) : AndroidViewModel(application) {

    private val repository = CryptoRepositoryImpl(application)

    private val getCryptoItemUseCase = GetCryptoItemUseCase(repository)
    private val getCryptoItemListUseCase = GetCryptoItemListUseCase(repository)
    private val loadDataUseCase = LoadDataUseCase(repository)

    val coinInfoList = getCryptoItemListUseCase()

    fun getDetailInfo(fSym: String) = getCryptoItemUseCase(fSym)

    init {
            loadDataUseCase()

    }
}