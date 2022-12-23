package pojo

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import javax.inject.Inject


data class CoinNameDto  (

    @SerializedName("Name")
    @Expose
    val name: String? = null


)