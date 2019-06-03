package com.feranstirman.basketballapp.Adapters

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.feranstirman.basketballapp.Entities.Game
import com.feranstirman.basketballapp.GameActivity
import com.feranstirman.basketballapp.R
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
        holder.itemView.tv_score_team1.text = game.sooreTeam1.toString()
        holder.itemView.tv_socre_team2.text = game.scoreTeam2.toString()

        holder.gameID = game.id

    }

    fun setGames(newGames: List<Game>) {
        games = newGames
        notifyDataSetChanged()
    }

}


class CustomViewholder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    var gameID: Int? = null

    init {

        itemView.setOnClickListener {
            val intent = Intent(itemView.context, GameActivity::class.java)
            intent.putExtra("gameID", gameID)
            itemView.context.startActivity(intent)
        }
    }

}