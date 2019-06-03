package com.feranstirman.basketballapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.feranstirman.basketballapp.Entities.Game
import com.feranstirman.basketballapp.ViewModels.GameViewModel
import com.feranstirman.basketballapp.databinding.ActivityNewGameBinding
import kotlinx.android.synthetic.main.activity_new_game.*
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class NewGameActivity : AppCompatActivity() {

    lateinit var scoreViewModel: ScoreViewModel
    lateinit var gameViewModel: GameViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_game)



        //CREATING THE VIEWMODELS AND DATABINDING
        scoreViewModel=ViewModelProviders.of(this).get(ScoreViewModel::class.java)
        var binding: ActivityNewGameBinding = DataBindingUtil.setContentView(this,R.layout.activity_new_game)
        binding.team = scoreViewModel

        btn_add1.setOnClickListener {
            scoreViewModel.scoreTeam1 = (scoreViewModel.scoreTeam1.toInt()+1).toString()
            binding.team = scoreViewModel
        }
        btn_add2.setOnClickListener {
            scoreViewModel.scoreTeam1 = (scoreViewModel.scoreTeam1.toInt()+2).toString()
            binding.team = scoreViewModel
        }
        btn_add3.setOnClickListener {
            scoreViewModel.scoreTeam1 = (scoreViewModel.scoreTeam1.toInt()+3).toString()
            binding.team = scoreViewModel
        }
        btn_add1_team2.setOnClickListener {
            scoreViewModel.scoreTeam2 = (scoreViewModel.scoreTeam2.toInt()+1).toString()
            binding.team = scoreViewModel
        }
        btn_add2_team2.setOnClickListener {
            scoreViewModel.scoreTeam2 = (scoreViewModel.scoreTeam2.toInt()+2).toString()
            binding.team = scoreViewModel
        }
        btn_add3_team2.setOnClickListener {
            scoreViewModel.scoreTeam2 = (scoreViewModel.scoreTeam2.toInt()+3).toString()
            binding.team = scoreViewModel
        }

        //WHEN I WANT TO SAVE THE GAME I JUST EDITED
        btn_endGame.setOnClickListener {
            val date = LocalDateTime.now()
            val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS")
            val dateFormatted = date.format(formatter)

            val winner:String

            gameViewModel = ViewModelProviders.of(this).get(GameViewModel::class.java)

            if(scoreViewModel.scoreTeam1.toInt()>scoreViewModel.scoreTeam2.toInt()){
                winner = tv_playing_team1.text.toString()
            }else{
                winner = tv_playing_team2.text.toString()
            }

            val newGame = Game(tv_playing_team1.text.toString(),tv_playing_team2.text.toString(),scoreViewModel.scoreTeam1.toInt(),scoreViewModel.scoreTeam2.toInt(),dateFormatted,winner)
            gameViewModel.insert(newGame)
            finish()

        }

        //CAMBIAR EL NOMBRE DEL EQUIPO QUE ESTA JUGANDO
        btn_confirm_team1.setOnClickListener {
            val team1 = et_team1.text.toString()
            tv_playing_team1.text = team1
        }
        btn_confirm_team2.setOnClickListener {
            val team2 = et_team2.text.toString()
            tv_playing_team2.text = team2
        }





    }
}
