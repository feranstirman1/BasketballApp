package com.feranstirman.basketballapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProviders
import com.feranstirman.basketballapp.AppConstants.AppConstants
import com.feranstirman.basketballapp.ViewModels.GameViewModel
import kotlinx.android.synthetic.main.activity_game.*

class GameActivity : AppCompatActivity() {

    private lateinit var gameViewModel: GameViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)

        gameViewModel = ViewModelProviders.of(this).get(GameViewModel::class.java)

        team1Name.text = intent.getStringExtra(AppConstants.TEAM1_NAME)
        team2Name.text = intent.getStringExtra(AppConstants.TEAM2_NAME)
        tv_scoreteam1.text = intent.getStringExtra(AppConstants.TEAM1_SCORE)
        tv_socreteam2.text = intent.getStringExtra(AppConstants.TEAM2_SCORE)
        tv_fecha.text = "Fecha: ${intent.getStringExtra(AppConstants.GAME_DATE)}"
        tv_winner.text = intent.getStringExtra(AppConstants.WINNER)


    }
}
