package pojo

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName




data class CoinInfoData (
    @SerializedName("RAW")
    @Expose
    private val raw: Raw? = null
)