package com.feranstirman.basketballapp.DAO

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.feranstirman.basketballapp.Entities.Game

@Dao
interface GameDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(game: Game)

    @Query("SELECT * FROM game_table")
    fun getAll(): LiveData<List<Game>>

    @Query("SELECT * FROM game_table WHERE id LIKE :gameID")
    fun getOne(gameID:Int): Game
}