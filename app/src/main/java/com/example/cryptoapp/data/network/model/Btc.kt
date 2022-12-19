package pojo

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName




data class Btc (
    @SerializedName("USD")
    @Expose
    private val usd: CoinInfoDto? = null
)