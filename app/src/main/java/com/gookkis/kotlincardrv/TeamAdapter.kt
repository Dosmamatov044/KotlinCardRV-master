package com.gookkis.kotlincardrv

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_grid_team.view.*
import kotlinx.android.synthetic.main.item_team.view.*
import kotlinx.android.synthetic.main.item_team.view.delete
import kotlinx.android.synthetic.main.item_team.view.img_team
import kotlinx.android.synthetic.main.item_team.view.tv_team

/*class TeamAdapter(private val teams: MutableList<Team>) : RecyclerView.Adapter<TeamHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TeamHolder {
        return TeamHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_team, parent, false))
    }




    override fun getItemCount(): Int {
        return teams.size
    }

    override fun onBindViewHolder(holder: TeamHolder, position: Int) {
        holder.bindTeam(teams[position])



    }



}

class TeamHolder(view: View) : RecyclerView.ViewHolder(view) {


    private val tvTeamName = view.tv_team
    private val imgTeam= view.img_team


    fun bindTeam(team: Team){
        tvTeamName.text = team.nameTeam

        Picasso.get().load(team.imageTeam).into(imgTeam)


    }



}*/