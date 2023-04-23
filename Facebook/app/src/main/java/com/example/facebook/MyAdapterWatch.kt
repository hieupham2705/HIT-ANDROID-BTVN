package com.example.facebook

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.MediaController
import android.widget.VideoView
import androidx.recyclerview.widget.RecyclerView
import com.example.facebook.databinding.FragmentWatchBinding

class MyAdapterWatch() : RecyclerView.Adapter<MyAdapterWatch.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_recy_watch,parent,false))
    }

    override fun getItemCount(): Int {
        return 200
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val s : String = "android.resource://com.example.facebook/" + R.raw.video
        holder.videoView.setVideoPath(s)
        holder.videoView.start()
    }

    class ViewHolder (item : View) : RecyclerView.ViewHolder(item){
        var videoView : VideoView
        init {
            videoView = item.findViewById(R.id.video)
        }

    }
}