package com.example.cryptoapp.data

import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class CryptoItem(

    var type: String,

    var market: String,

    var fromsymbol: String,

    var tosymbol: String,

    var flags: String,

    var price: String,

    var lastupdate: String,

    var median: String,

    var lastvolume: String,

    var lastvolumeto: String,

    var lasttradeid: String,

    var volumeday: String,

    var volumedayto: String,

    var volume24hour: String,

    var volume24hourto: String,

    var openday: String,

    var highday: String,

    var lowday: String,

    var open24hour: String,

    var high24hour: String,

    var low24hour: String,

    var lastmarket: String,

    var volumehour: String,

    var volumehourto: String,

    var openhour: String,

    var highhour: String,

    var lowhour: String,

    var toptiervolume24hour: String,

    var toptiervolume24hourto: String,

    var change24hour: String,

    var changepct24hour: String,

    var changeday: String,

    var changepctday: String,

    var changehour: String,

    var changepcthour: String,

    var conversiontype: String,

    var conversionsymbol: String,

    var supply: String,

    var mktcap: String,

    var mktcappenalty: String,

    var circulatingsupply: String,

    var circulatingsupplymktcap: String,

    var totalvolume24h: String,

    var totalvolume24hto: String,

    var totaltoptiervolume24h: String,

    var totaltoptiervolume24hto: String,

    var imageurl: String
) {
}