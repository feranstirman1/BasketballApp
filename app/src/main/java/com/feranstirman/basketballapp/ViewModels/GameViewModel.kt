package com.feranstirman.basketballapp.ViewModels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.feranstirman.basketballapp.Database.BasketballDB
import com.feranstirman.basketballapp.Entities.Game
import com.feranstirman.basketballapp.Repositories.GameRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class GameViewModel(app: Application) : AndroidViewModel(app) {

    private val repository: GameRepository

    init {
        val gameDao = BasketballDB.getInstance(app, viewModelScope).gameDao()
        repository = GameRepository(gameDao)
    }

    fun insert(game: Game) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.insert(game)
        }
    }

    fun getAll(): LiveData<List<Game>> {
        return repository.getAll()
    }

    fun getOne(gameID: Int): Game {

        return repository.getOne(gameID)


    }


}