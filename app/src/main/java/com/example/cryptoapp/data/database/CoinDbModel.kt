package com.example.cryptoapp.data.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "crypto_item")
data class CoinDbModel (

    @PrimaryKey
    var fromsymbol: String,

    var tosymbol: String?,

    var price: String?,

    var lastupdate: String?,

    var highday: String?,

    var lowday: String?,

    var lastmarket: String?,

    var imageurl: String?
)