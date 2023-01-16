package com.example.cryptoapp.presentation.viewModel


import androidx.lifecycle.*
import com.example.cryptoapp.addFavorites.domain.AddToFavoritesUseCase
import com.example.cryptoapp.domain.GetCryptoItemListUseCase
import com.example.cryptoapp.domain.GetCryptoItemUseCase
import com.example.cryptoapp.domain.LoadDataUseCase
import kotlinx.coroutines.launch
import androidx.lifecycle.asLiveData
import javax.inject.Inject

class CoinViewModel @Inject constructor(
    private val getCryptoItemUseCase: GetCryptoItemUseCase,
    private val getCryptoItemListUseCase: GetCryptoItemListUseCase,
    private val loadDataUseCase: LoadDataUseCase,
    private val addToFavoritesUseCase: AddToFavoritesUseCase
) : ViewModel () {


    fun addToFavoriteList (fSym: String) {
        viewModelScope.launch {
           addToFavoritesUseCase(fSym)
        }
    }

    val coinInfoList = getCryptoItemListUseCase().asLiveData()

    fun getDetailInfo(fSym: String) = getCryptoItemUseCase(fSym).asLiveData()

    init {
        loadDataUseCase()
    }
}