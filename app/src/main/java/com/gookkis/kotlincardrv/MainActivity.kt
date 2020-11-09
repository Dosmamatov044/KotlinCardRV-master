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
                imageTeam = "https://www.thesportsdb.com/images/media/team/badge/eqayrf1523184794.png"
            ),
            Team(
                nameTeam = "Man City",
                imageTeam = "https://www.thesportsdb.com/images/media/team/badge/vwpvry1467462651.png"
            ),
            Team(
                nameTeam = "Liverpool",
                imageTeam = "https://www.thesportsdb.com/images/media/team/badge/uvxuqq1448813372.png"
            ),
            Team(
                nameTeam = "Man United",
                imageTeam = "https://www.thesportsdb.com/images/media/team/badge/xzqdr11517660252.png"
            ),
            Team(
                nameTeam = "Chelsea",
                imageTeam = "https://www.thesportsdb.com/images/media/team/badge/yvwvtu1448813215.png"
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

        if(groupAdapter.itemCount ==1&&listTeam?.size!=0) {
        button?.visibility=View.INVISIBLE
            groupAdapter.notifyDataSetChanged()

    }
    }

    override fun onButtonAdd(show: Int) {
        Snackbar.make(root, "Text Clicked $show",Snackbar.LENGTH_SHORT).show()
    }

    override fun onEditText(changeUrlText: String, idTextView: Int) {

        if (changeUrlText.startsWith("http")){
         listTeam= arrayListOf(Team("newPhoto",changeUrlText))
        listTeam!!.map {
            groupAdapter.add(TeamItem(it, this, this))
            button?.visibility=View.VISIBLE
            groupAdapter.notifyDataSetChanged()
        }}}


    override fun onTeamClicked(team: Team) {
        Snackbar.make(root, team.nameTeam, Snackbar.LENGTH_SHORT).show()

    }

    override fun onTextClicked(team: Team) {
        Snackbar.make(root, "Text Clicked " + team.nameTeam, Snackbar.LENGTH_SHORT).show()
    }


}