package pojo

import com.google.gson.JsonObject
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import javax.inject.Inject

data class CoinInfoJsonContainerDTO (
    @SerializedName("RAW")
    @Expose
    val jsonObject: JsonObject? = null
)