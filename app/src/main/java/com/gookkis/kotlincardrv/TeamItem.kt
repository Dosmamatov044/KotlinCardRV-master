package com.gookkis.kotlincardrv

import android.R.attr.direction
import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.content.Context
import android.os.Build
import android.view.View

import androidx.annotation.RequiresApi
import com.squareup.picasso.Picasso
import com.xwray.groupie.kotlinandroidextensions.Item
import com.xwray.groupie.kotlinandroidextensions.ViewHolder
import kotlinx.android.synthetic.main.item_grid_team.view.*


class TeamItem(
    private val teams: Team,
    private val listener: TeamListener,
    private val context: Context
) : Item() {



    @RequiresApi(Build.VERSION_CODES.M)
    override fun bind(viewHolder: ViewHolder, position: Int) {

        viewHolder.itemView.tv_team.text = teams.nameTeam
        Picasso.get().load(teams.imageTeam).into(viewHolder.itemView.img_team)

        viewHolder.itemView.show.setOnClickListener {
            listener.onButtonAdd(viewHolder.adapterPosition)
            if (isClickable) {

                viewHolder.itemView.addUrl.visibility = View.VISIBLE
                viewHolder.itemView.editUrl.visibility = View.VISIBLE
            }
        }
        viewHolder.itemView.img_team.setOnClickListener {
            listener.onTeamClicked(teams)
        }
        viewHolder.itemView.tv_team.setOnClickListener {
            listener.onTextClicked(teams)
        }
        viewHolder.itemView.delete.setOnClickListener {
            val animatorSet = AnimatorSet()
            val animator_Y: ObjectAnimator = ObjectAnimator.ofFloat(
                viewHolder.itemView,
                "translationY",
                100F,
                0F

            )
            animator_Y.duration = 3000

            val animator_X: ObjectAnimator =
                ObjectAnimator.ofFloat(viewHolder.itemView, "translationX", -20F, 20F, 0F)
            animator_X.duration = 3000

            animatorSet.playTogether(animator_X, animator_Y)
            animatorSet.start()

            listener.onButtonDelete(viewHolder.adapterPosition, R.id.delete)

        }

        viewHolder.itemView.addUrl.setOnClickListener {
            val str = viewHolder.itemView.editUrl.text.toString()

            listener.onEditText(str, R.id.editUrl)
        }
    }

    override fun getLayout() = R.layout.item_grid_team

}


interface TeamListener {

    fun onTeamClicked(team: Team)
    fun onTextClicked(team: Team)
    fun onButtonDelete(delete: Int, idDelete: Int)
    fun onButtonAdd(show: Int)
    fun onEditText(changeUrlText: String, idTextView: Int)


}
