package com.example.cryptoapp.addFavorites.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [FavoriteCoinDbModel::class], version = 1, exportSchema = false)
abstract class FavoriteAppDataBase : RoomDatabase() {

    abstract fun favoriteCoinDao () : FavoriteCoinDao

    companion object {
        private var db : FavoriteAppDataBase? = null

        private const val DB_NAME = "name.db"

        private var LOCK = Any()

        fun getInstance (context: Context) : FavoriteAppDataBase {
            synchronized(LOCK){
                db?.let { return it }
                val instance = Room.databaseBuilder(
                    context,
                    FavoriteAppDataBase::class.java,
                    DB_NAME
                )
                    .fallbackToDestructiveMigration()
                    .build()
                db = instance
                return instance
            }
        }
    }
}