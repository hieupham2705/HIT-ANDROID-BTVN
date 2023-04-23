package com.example.facebook

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlin.coroutines.coroutineContext

class MyAdapterHome(private val context : Context) : RecyclerView.Adapter<MyAdapterHome.ViewHoderHome>() {
    class ViewHoderHome(item : View) : RecyclerView.ViewHolder(item) {
        val item_recy_stories = item.findViewById<RecyclerView>(R.id.recycler_layout_stories)
        val item_recy_news = item.findViewById<RecyclerView>(R.id.recycler_layout_news)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyAdapterHome.ViewHoderHome {
        return ViewHoderHome(LayoutInflater.from(parent.context).inflate(R.layout.item_recy_home,parent,false))
    }

    override fun onBindViewHolder(holder: MyAdapterHome.ViewHoderHome, position: Int) {
        holder.item_recy_stories.layoutManager = GridLayoutManager(context,1,RecyclerView.HORIZONTAL,false)
        holder.item_recy_stories.adapter = MyAdapterStories()
        holder.item_recy_news.layoutManager =LinearLayoutManager(context)
        holder.item_recy_news.adapter = MyAdapterNews()
    }

    override fun getItemCount(): Int = 1
}