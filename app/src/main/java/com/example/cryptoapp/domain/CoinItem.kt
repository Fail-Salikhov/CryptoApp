package com.example.cryptoapp.domain

import javax.inject.Inject

data class CoinItem  (

    var fromsymbol: String,

    var tosymbol: String?,

    var price: String?,

    var lastupdate: String,

    var highday: String?,

    var lowday: String?,

    var lastmarket: String?,

    var imageurl: String
) {
}