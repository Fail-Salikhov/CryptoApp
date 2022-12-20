package databasw

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.cryptoapp.data.database.CoinDbModel

@Database(entities = [CoinDbModel::class], version = 4, exportSchema = false)
abstract class AppDataBase : RoomDatabase () {


    companion object{
        private var db: AppDataBase? = null

        private const val DB_NAME = "name.db"

        private var LOCK = Any()

        fun getInstance (contex: Context): AppDataBase {
            synchronized(LOCK) {
                db?.let { return it }
                val instance = Room.databaseBuilder(
                    contex,
                    AppDataBase::class.java,
                    DB_NAME
                )
                    .fallbackToDestructiveMigration()
                    .build()
                db = instance
                return instance
            }
        }
    }

    abstract fun coinPriceInfoDao() : CoinInfoDao
}