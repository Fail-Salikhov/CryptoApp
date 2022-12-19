package pojo

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName




data class Raw (
    @SerializedName("BTC")
    @Expose
    private val btc: Btc? = null
)