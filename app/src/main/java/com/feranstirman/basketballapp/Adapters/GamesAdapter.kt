package com.feranstirman.basketballapp.Adapters

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.feranstirman.basketballapp.AppConstants.AppConstants
import com.feranstirman.basketballapp.Entities.Game
import com.feranstirman.basketballapp.GameActivity
import com.feranstirman.basketballapp.R
import kotlinx.android.synthetic.main.activity_game.view.*
import kotlinx.android.synthetic.main.game_item.view.*

class GamesAdapter : RecyclerView.Adapter<CustomViewholder>() {

    private var games = emptyList<Game>()

    override fun getItemCount(): Int {
        return games.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewholder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.game_item, parent, false)
        return CustomViewholder(itemView)
    }

    override fun onBindViewHolder(holder: CustomViewholder, position: Int) {
        val game = games.get(position)
        holder.itemView.nomreEquipo1.text = game.team1
        holder.itemView.nomreEquipo2.text = game.team2
        holder.itemView.tv_score_team1.text = game.sooreTeam1.toString()
        holder.itemView.tv_socre_team2.text = game.scoreTeam2.toString()
        holder.itemView.gameDate.text = game.date
        holder.itemView.gameID.text = game.id.toString()

    }

    fun setGames(newGames: List<Game>) {
        games = newGames
        notifyDataSetChanged()
    }

}


class CustomViewholder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    init {
        itemView.setOnClickListener {
            val intent = Intent(itemView.context, GameActivity::class.java)
            intent.putExtra(AppConstants.GAME_ID, itemView.gameID.text)
            intent.putExtra(AppConstants.TEAM1_SCORE,itemView.tv_score_team1.text)
            intent.putExtra(AppConstants.TEAM2_SCORE,itemView.tv_socre_team2.text)
            intent.putExtra(AppConstants.GAME_DATE,itemView.gameDate.text)
            intent.putExtra(AppConstants.TEAM1_NAME,itemView.nomreEquipo1.text)
            intent.putExtra(AppConstants.TEAM2_NAME,itemView.nomreEquipo2.text)
            itemView.context.startActivity(intent)
        }
    }

}


