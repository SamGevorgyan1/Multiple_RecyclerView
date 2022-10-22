package com.multiplerecyclerview.utils

import android.content.Context
import android.content.Intent
import android.widget.ImageView
import com.multiplerecyclerview.R


object Utils {

    fun likeClicked(context: Context,imageView: ImageView){

            imageView.setBackgroundResource(R.drawable.ic_vector_like_clicked)

    }

    fun shareItem(context: Context){

            val shareIntent = Intent()
            val share2:String="nothing"
            shareIntent.action = Intent.ACTION_SEND
            shareIntent.type="text/plain"
            shareIntent.putExtra(Intent.EXTRA_LOCAL_ONLY, share2);
            context.startActivity(Intent.createChooser(shareIntent,"Share via"))

    }
    }
