package com.example.cryptoapp.addFavorites.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cryptoapp.addFavorites.domain.DeleteCoinFromFavoriteUseCase
import com.example.cryptoapp.addFavorites.domain.GetFavoriteCoinListUseCase
import com.example.cryptoapp.domain.GetCryptoItemUseCase
import kotlinx.coroutines.launch
import javax.inject.Inject

class FavoriteCoinViewModel @Inject constructor(
    private val getFavoriteCoinListUseCase : GetFavoriteCoinListUseCase,
    private val deleteCoinFromFavoriteUseCase: DeleteCoinFromFavoriteUseCase,
    private val getCryptoItemUseCase: GetCryptoItemUseCase
) : ViewModel() {

    val favoriteCoinList = getFavoriteCoinListUseCase()

    fun getCryptoItemUseCse (fSym: String) = getCryptoItemUseCase(fSym)

    fun deleteFavoriteCoin (fromSymbol: String) {
        viewModelScope.launch {
            deleteCoinFromFavoriteUseCase(fromSymbol)
        }
    }
}