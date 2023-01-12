package com.example.cryptoapp.di

import androidx.lifecycle.ViewModel
import com.example.cryptoapp.addFavorites.presentation.FavoriteCoinViewModel
import com.example.cryptoapp.presentation.viewModel.CoinViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(CoinViewModel::class)
    fun bindCoinViewModel(viewModel: CoinViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(FavoriteCoinViewModel::class)
    fun bindFavoriteCoinViewModel (viewModel : FavoriteCoinViewModel) : ViewModel
}