package com.example.facebook

import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.VideoView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView

class MyAdapterStories : RecyclerView.Adapter<MyAdapterStories.ViewHoderStories>() {
    class ViewHoderStories(item: View) : RecyclerView.ViewHolder(item) {
        val video = item.findViewById<VideoView>(R.id.videostories)
        val cardview = item.findViewById<LinearLayout>(R.id.cardview)

    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MyAdapterStories.ViewHoderStories {
        return ViewHoderStories(
            LayoutInflater.from(parent.context).inflate(R.layout.item_recy_stories, parent, false)
        )
    }

    override fun onBindViewHolder(holder: MyAdapterStories.ViewHoderStories, position: Int) {

        holder.cardview.setOnClickListener {
            Log.e("keyy ", position.toString())
            holder.video.setOnClickListener {
                startActivity(Intent(this,MainActivity::class.java))
            }
        }
    }

    override fun getItemCount(): Int = 3
}