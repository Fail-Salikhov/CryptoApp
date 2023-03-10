package pojo

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName
import javax.inject.Inject


data class CoinNameContainerDto(
    @SerializedName("CoinInfo")
    @Expose
    val coinName: CoinNameDto? = null

)