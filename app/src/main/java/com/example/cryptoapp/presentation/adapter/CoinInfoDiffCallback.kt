package com.example.cryptoapp.presentation.adapter

import androidx.recyclerview.widget.DiffUtil
import com.example.cryptoapp.domain.CoinItem
import javax.inject.Inject

object CoinInfoDiffCallback : DiffUtil.ItemCallback<CoinItem>() {
    override fun areItemsTheSame(oldItem: CoinItem, newItem: CoinItem): Boolean {
        return oldItem.fromsymbol == newItem.fromsymbol
    }

    override fun areContentsTheSame(oldItem: CoinItem, newItem: CoinItem): Boolean {
        return oldItem == newItem
    }
}