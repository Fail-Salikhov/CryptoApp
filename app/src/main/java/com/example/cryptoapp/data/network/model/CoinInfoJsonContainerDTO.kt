package pojo

import com.google.gson.JsonObject
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class CoinInfoJsonContainerDTO (
    @SerializedName("DISPLAY")
    @Expose
    val jsonObject: JsonObject? = null
)