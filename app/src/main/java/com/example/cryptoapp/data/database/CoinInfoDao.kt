package databasw

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.cryptoapp.data.database.CoinDbModel
import kotlinx.coroutines.flow.Flow

@Dao
interface CoinInfoDao {

    @Query("SELECT * FROM crypto_item ORDER BY lastupdate")
    fun getPriceList (): Flow<List<CoinDbModel>>

    @Query("SELECT * FROM crypto_item WHERE fromsymbol == :fSym LIMIT 1")
    fun getPriceInfoAboutCoin (fSym: String) : Flow<CoinDbModel>

    @Query("SELECT * FROM crypto_item WHERE fromsymbol == :fSym LIMIT 1")
    suspend fun getCoinDbModel (fSym: String) : CoinDbModel

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun  insertPriseList (priceList: List<CoinDbModel>)
}