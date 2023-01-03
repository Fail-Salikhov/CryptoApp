package com.example.cryptoapp.presentation.viewModel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cryptoapp.addFavorites.data.database.FavoriteCoinDao
import com.example.cryptoapp.addFavorites.data.database.FavoriteCoinDbModel
import com.example.cryptoapp.addFavorites.domain.AddToFavoritesUseCase
import com.example.cryptoapp.data.repositori.CryptoRepositoryImpl
import com.example.cryptoapp.domain.GetCryptoItemListUseCase
import com.example.cryptoapp.domain.GetCryptoItemUseCase
import com.example.cryptoapp.domain.LoadDataUseCase
import kotlinx.coroutines.launch
import javax.inject.Inject

class CoinViewModel @Inject constructor(
    private val getCryptoItemUseCase: GetCryptoItemUseCase,
    private val getCryptoItemListUseCase: GetCryptoItemListUseCase,
    private val loadDataUseCase: LoadDataUseCase,
    private val addToFavoritesUseCase: AddToFavoritesUseCase,
    private val favoriteCoinDao: FavoriteCoinDao
) : ViewModel () {


    fun addToFavoriteList (fSym: String) {
        viewModelScope.launch {
           addToFavoritesUseCase(fSym)
        }

    }


    val coinInfoList = getCryptoItemListUseCase()

    fun getDetailInfo(fSym: String) = getCryptoItemUseCase(fSym)

    init {
        loadDataUseCase()
    }
}