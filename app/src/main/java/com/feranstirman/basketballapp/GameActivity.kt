package com.feranstirman.basketballapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import com.feranstirman.basketballapp.ViewModels.GameViewModel
import kotlinx.android.synthetic.main.activity_game.*

class GameActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)

        val gameViewModel = ViewModelProviders.of(this).get(GameViewModel::class.java)

        val gameID:Int = intent.getIntExtra("gameID",-1)

        val game = gameViewModel.getOne(gameID)

        tv_score_team1.text = game.sooreTeam1.toString()
        tv_socre_team2.text = game.scoreTeam2.toString()
        tv_fecha.text = game.date

    }
}
