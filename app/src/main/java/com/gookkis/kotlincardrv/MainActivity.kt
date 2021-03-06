package com.gookkis.kotlincardrv

import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import android.view.View.OnTouchListener
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.PagerSnapHelper
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.SnapHelper

import com.google.android.material.snackbar.Snackbar
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.kotlinandroidextensions.ViewHolder
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), TeamListener {
    var button: Button? = null
private var isAdding:Boolean=false


    //    private var view: View? = null
    private var listTeam: MutableList<Team>? = null
    private val groupAdapter = GroupAdapter<ViewHolder>()
// val recyclerView:RecyclerView?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        listTeam = arrayListOf(
            Team(
                nameTeam = "Everton",
                imageTeam = "https://www.thesportsdb.com/images/media/team/badge/eqayrf1523184794.png",
                player_img = "https://www.thesportsdb.com/images/media/player/render/small/es4zhk1585671612.png"
            ),
            Team(
                nameTeam = "Man City",
                imageTeam = "https://www.thesportsdb.com/images/media/team/badge/vwpvry1467462651.png",
            player_img = "https://www.thesportsdb.com/images/media/player/banner/gp4eiz1600017457.jpg"),
            Team(
                nameTeam = "Liverpool",
                imageTeam = "https://www.thesportsdb.com/images/media/team/badge/uvxuqq1448813372.png",
                player_img = "https://www.thesportsdb.com/images/media/player/render/small/41r4nq1559589736.png"
            ),
            Team(
                nameTeam = "Man United",
                imageTeam = "https://www.thesportsdb.com/images/media/team/badge/xzqdr11517660252.png",
                player_img = "https://www.thesportsdb.com/images/media/player/render/small/09foh91557911811.png"
            ),
            Team(
                nameTeam = "Chelsea",
                imageTeam = "https://www.thesportsdb.com/images/media/team/badge/yvwvtu1448813215.png"
            , player_img = "https://www.thesportsdb.com/images/media/player/render/small/j66w321557998250.png"
            ))

        //val teamAdapter = TeamAdapter(listTeam)
        listTeam!!.map {
            groupAdapter.add(TeamItem(it, this, this))
groupAdapter.notifyDataSetChanged()

        }

        rv_team.apply {

            layoutManager = LinearLayoutManager(this@MainActivity, RecyclerView.HORIZONTAL, false)
            adapter = groupAdapter

           

       groupAdapter.notifyDataSetChanged()
        }

    }

    override fun onButtonDelete(delete: Int, idDelete: Int) {
        val count: Int=delete
        button=findViewById(idDelete)





        groupAdapter.removeGroup(delete)
        groupAdapter.notifyItemRemoved(delete)
        groupAdapter.notifyItemChanged(delete)
        groupAdapter.notifyItemRangeRemoved(0, count)
        groupAdapter.notifyDataSetChanged()


      if (isAdding){
        if(groupAdapter.itemCount ==1&&listTeam?.size!=0) {
            button?.visibility = View.INVISIBLE
            groupAdapter.notifyDataSetChanged()
       isAdding=false

        }
    }else{
          button?.visibility=View.VISIBLE
          isAdding=true

      }
    }

    override fun onButtonAdd(show: Int) {
        Snackbar.make(root, "Text Clicked $show",Snackbar.LENGTH_SHORT).show()
    }

    override fun onEditTextButton(changeUrlText: String, idTextView: Int) {

        if (changeUrlText.startsWith("https://"
            )){
         listTeam= arrayListOf(Team("newPhoto",changeUrlText,"-"))
            button?.visibility=View.VISIBLE
        listTeam!!.map {
            groupAdapter.add(TeamItem(it, this, this))

            groupAdapter.notifyDataSetChanged()
        } }else{
Utils.showToast(this,"Данный урл добавить нельзя, попробуйте добавить url начинающийся с https")


        }
    }

    override fun onTeamClicked(team: Team) {
        Snackbar.make(root, team.nameTeam, Snackbar.LENGTH_SHORT).show()

    }

    override fun onTextClicked(team: Team) {
        Utils.showSnackBar(root,"TextClick")
    }
}