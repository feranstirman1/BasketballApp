package com.feranstirman.basketballapp.Database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.feranstirman.basketballapp.DAO.GameDao
import com.feranstirman.basketballapp.Entities.Game
import kotlinx.coroutines.CoroutineScope

@Database(entities = [Game::class],version = 1,exportSchema = false)
abstract class BasketballDB:RoomDatabase() {

    abstract fun gameDao():GameDao

    companion object{

        @Volatile
        var INSTANCE:BasketballDB?=null

        fun getInstance(context: Context,scope: CoroutineScope):BasketballDB{

            if(INSTANCE != null){
                return INSTANCE!!
            }else{
                INSTANCE = Room
                        .databaseBuilder(context,BasketballDB::class.java,"BasketballDB")
                        .build()
                return INSTANCE!!
            }

        }
    }

}