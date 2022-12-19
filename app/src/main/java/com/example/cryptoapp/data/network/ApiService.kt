package com.example.cryptoapp.data.network

import pojo.CoinInfoJsonContainerDTO
import pojo.CoinNamesListDto
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("top/totalvolfull")
    suspend fun getTopCoinsInfo (
        @Query(QUERY_PARAM_API_KEY) apiKey : String = "dba3e4fc18aa12a921784c28daa091181ac3582c32733fdba6b94c4c30fff07e",
        @Query(QUERY_PARAM_LIMIT) limit : Int = 10,
        @Query(QUERY_PARAM_TO_SYMBOL) tSym : String = CURRENCY
    ): CoinNamesListDto

//    @GET("pricemultifull")
//    fun getFullPriceList (
//        @Query(QUERY_PARAM_API_KEY) apiKey : String = "dba3e4fc18aa12a921784c28daa091181ac3582c32733fdba6b94c4c30fff07e",
//        @Query(QUERY_PARAM_FROM_SYMBOL) fSyms : String ="BTC",
//        @Query(QUERY_PARAM_TO_SYMBOLS) tSyms : String = CURRENCY
//        ) : Single <CoinInfoData>

    @GET("pricemultifull")
    suspend fun getFullPriceListJSON (
        @Query(QUERY_PARAM_FROM_SYMBOL) fSyms : String,
        @Query(QUERY_PARAM_TO_SYMBOLS) tSyms : String = CURRENCY
    ) : CoinInfoJsonContainerDTO

   companion object{
       private const val QUERY_PARAM_LIMIT = "limit"
       private const val QUERY_PARAM_TO_SYMBOL = "tsym"
       private const val QUERY_PARAM_API_KEY = "api_key"
       private const val QUERY_PARAM_TO_SYMBOLS = "tsyms"
       private const val QUERY_PARAM_FROM_SYMBOL = "fsyms"



       private const val CURRENCY = "USD"
   }
}
