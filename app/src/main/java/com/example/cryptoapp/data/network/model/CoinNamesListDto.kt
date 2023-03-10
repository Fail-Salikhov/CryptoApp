package pojo

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName
import javax.inject.Inject


data class CoinNamesListDto (
    @SerializedName("Data")
    @Expose
    val names: List<CoinNameContainerDto>? = null

)