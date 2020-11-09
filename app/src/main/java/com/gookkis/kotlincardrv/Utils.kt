package com.gookkis.kotlincardrv

import android.annotation.SuppressLint
import android.content.Context
import android.widget.Toast
import android.widget.Toast.makeText

  class Utils {

companion object Factory{
      @SuppressLint("ShowToast")
      fun showToast(mContext:Context, message: String) {
          makeText(mContext, message, Toast.LENGTH_SHORT).show()

      }
}




}