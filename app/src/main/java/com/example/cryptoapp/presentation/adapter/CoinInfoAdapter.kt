package com.example.cryptoapp.presentation.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.cryptoapp.R
import com.example.cryptoapp.databinding.ActivityMainBinding
import com.example.cryptoapp.databinding.ItemCoinInfoBinding
import com.example.cryptoapp.domain.CoinItem
import com.squareup.picasso.Picasso


class CoinInfoAdapter(private val context: Context): ListAdapter<CoinItem, CoinIfoViewHolder>(CoinInfoDiffCallback) {


    var onCoinClickListener: OnCoinClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CoinIfoViewHolder {
        val binding = ItemCoinInfoBinding.inflate(
            LayoutInflater.from(parent.context), parent, false)
        return CoinIfoViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CoinIfoViewHolder, position: Int) {
        val coin = getItem(position)
        when{
            coin.fromsymbol == "Ξ" -> holder.binding.tvSymbols.text = "ETH" + "/" + coin.tosymbol
            coin.fromsymbol == "Ƀ" -> holder.binding.tvSymbols.text = "BTC" + "/" + coin.tosymbol
            else -> holder.binding.tvSymbols.text = coin.fromsymbol + "/" + coin.tosymbol
        }
        val symbolsTemplate = context.resources.getString(R.string.symbols_template)
        val lastUpdateTemplate = context.resources.getString(R.string.last_update_template)
        holder.binding.tvPrice.text = coin.price
        holder.binding.tvLastUpdate.text = String.format(lastUpdateTemplate, coin.lastupdate)
//        holder.binding.tvLastUpdate.text = coin.lastupdate
        Picasso.get().load(coin.imageurl).into(holder.binding.ivLogoCoin)
        holder.itemView.setOnClickListener {
            onCoinClickListener?.onCoinClick(coin)
        }
    }


    interface OnCoinClickListener {
        fun onCoinClick (coinItem: CoinItem)
    }
}