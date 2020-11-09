package com.gookkis.kotlincardrv

import android.app.Activity
import android.content.Context
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import kotlin.coroutines.coroutineContext

class MyAnim (context: Context) {

    companion object GetAnimation{
        private  lateinit var context:Context


    fun ItemTap(view:View) {
        val animation: Animation =
            AnimationUtils.loadAnimation(context, R.anim.fade_scale_animation)
   animation.duration=20
        view.startAnimation(animation)

    }

}


  }