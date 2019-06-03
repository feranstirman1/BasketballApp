package com.feranstirman.basketballapp.Repositories

import androidx.lifecycle.LiveData
import com.feranstirman.basketballapp.DAO.GameDao
import com.feranstirman.basketballapp.Entities.Game

class GameRepository(val gameDao: GameDao) {

    suspend fun insert(game: Game){
        gameDao.insert(game)
    }

    fun getAll(): LiveData<List<Game>> {
        return gameDao.getAll()
    }

    fun getOne(gameID:Int): Game{
        return gameDao.getOne(gameID)
    }


}