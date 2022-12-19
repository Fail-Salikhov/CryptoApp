package databasw

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.cryptoapp.data.database.CoinDbModel
import pojo.CoinInfoDto

@Dao
interface CoinInfoDao {

    @Query("SELECT * FROM crypto_item ORDER BY lastupdate")
    fun getPriceList (): LiveData<List<CoinDbModel>>

    @Query("SELECT * FROM crypto_item WHERE fromsymbol == :fSym LIMIT 1")
    fun getPriceInfoAboutCoin (fSym: String) : LiveData<CoinDbModel>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun  insertPriseList (priceList: List<CoinDbModel>)
}