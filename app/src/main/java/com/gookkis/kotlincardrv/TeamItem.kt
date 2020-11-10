package com.gookkis.kotlincardrv

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
        Picasso.get().load(teams.player_img).into(viewHolder.itemView.player_Img)
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
            //1 start
            val animatorButton = AnimatorSet()
            val animator_Y1: ObjectAnimator = ObjectAnimator.ofFloat(
                viewHolder.itemView.delete,
                "translationY",
                100F,
                0F
            )
            animator_Y1.duration = 2000

            val animator_X1: ObjectAnimator =
                ObjectAnimator.ofFloat(viewHolder.itemView.delete, "translationX", -70F, 40F, 0F)

            animatorButton.duration = 2000

            animatorButton.playTogether(animator_X1, animator_Y1)
            animatorButton.start()
//1 end
//2 start
            val animatorSet = AnimatorSet()
            val animator_Y: ObjectAnimator = ObjectAnimator.ofFloat(
                viewHolder.itemView,
                "translationY",
                100F,
                0F
            )
            animator_Y.duration = 2000

            val animator_X: ObjectAnimator =
                ObjectAnimator.ofFloat(viewHolder.itemView, "translationX", -20F, 20F, 0F)

            animator_X.duration = 2000

            animatorSet.playTogether(animator_X, animator_Y)
            animatorSet.start()
//2 end
//3 start
            val animatorButtonAdd = AnimatorSet()
            val animator_Y2: ObjectAnimator = ObjectAnimator.ofFloat(
                viewHolder.itemView.show,
                "translationY",
                150F,
                8F, 3F
            )
            animator_Y1.duration = 2000

            val animator_X2: ObjectAnimator =
                ObjectAnimator.ofFloat(viewHolder.itemView.delete, "translationX", -70F, 40F, 0F)

            animatorButton.duration = 2000

            animatorButton.playTogether(animator_X2, animator_Y2)
            animatorButton.start()
//3 end
            listener.onButtonDelete(viewHolder.adapterPosition, R.id.delete)
        }

        viewHolder.itemView.addUrl.setOnClickListener {
            val str = viewHolder.itemView.editUrl.text.toString()

            listener.onEditTextButton(str, R.id.editUrl)
        }
    }

    override fun getLayout() = R.layout.item_grid_team
}


interface TeamListener {

    fun onTeamClicked(team: Team)
    fun onTextClicked(team: Team)
    fun onButtonDelete(delete: Int, idDelete: Int)
    fun onButtonAdd(show: Int)
    fun onEditTextButton(changeUrlText: String, idTextView: Int)

}
