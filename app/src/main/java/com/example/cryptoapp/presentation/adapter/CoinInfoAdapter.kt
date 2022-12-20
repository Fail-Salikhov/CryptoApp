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
import com.example.cryptoapp.data.network.ApiFactory.BASE_URL_IMAGE
import com.example.cryptoapp.domain.CoinItem
import com.squareup.picasso.Picasso


class CoinInfoAdapter(private val context: Context): ListAdapter<CoinItem, CoinInfoAdapter.CoinIfoViewHolder>(CoinInfoDiffCallback) {


    var onCoinClickListener: OnCoinClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CoinIfoViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_coin_info, parent, false)
        return CoinIfoViewHolder(view)
    }

    override fun onBindViewHolder(holder: CoinIfoViewHolder, position: Int) {
        val coin = getItem(position)
        when{
            coin.fromsymbol == "Ξ" -> holder.tvSymbols.text = "ETH" + "/" + coin.tosymbol
            coin.fromsymbol == "Ƀ" -> holder.tvSymbols.text = "BTC" + "/" + coin.tosymbol
            else -> holder.tvSymbols.text = coin.fromsymbol + "/" + coin.tosymbol
        }
        val symbolsTemplate = context.resources.getString(R.string.symbols_template)
        val lastUpdateTemplate = context.resources.getString(R.string.last_update_template)
        holder.tvPrice.text = coin.price
//        holder.tvTime.text = String.format(lastUpdateTemplate, convertTimestampToTime(lastUpdate))
        holder.tvTime.text = coin.lastupdate
        Picasso.get().load(BASE_URL_IMAGE+ coin.imageurl).into(holder.imageViewCoin)
        holder.itemView.setOnClickListener {
            onCoinClickListener?.onCoinClick(coin)
        }
    }


    inner class CoinIfoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        var imageViewCoin: ImageView = itemView.findViewById(R.id.ivLogoCoin)
        var tvSymbols = itemView.findViewById<TextView>(R.id.tvSymbols)
        var tvPrice = itemView.findViewById<TextView>(R.id.tvPrice)
        var tvTime = itemView.findViewById<TextView>(R.id.tvLastUpdate)

    }

    interface OnCoinClickListener {
        fun onCoinClick (coinItem: CoinItem)
    }
}