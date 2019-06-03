package com.feranstirman.basketballapp.Entities

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "game_table")
data class Game(
        val team1:String,
        val team2:String,
        val sooreTeam1:Int,
        val scoreTeam2:Int,
        val date: String,
        val winner:String
){
    @PrimaryKey(autoGenerate = true)
    var id:Int = 0
}