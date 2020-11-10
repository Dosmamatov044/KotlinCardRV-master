package com.gookkis.kotlincardrv

import android.annotation.SuppressLint
import android.content.Context
import android.view.View
import android.widget.Toast
import android.widget.Toast.makeText
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*

class Utils {

companion object Factory{
      @SuppressLint("ShowToast")
      fun showToast(mContext:Context, message: String) {
          makeText(mContext, message, Toast.LENGTH_SHORT).show()





      }
    fun showSnackBar(view:View,message: String){

        Snackbar.make(view, message, Snackbar.LENGTH_SHORT).show()


    }



}




}