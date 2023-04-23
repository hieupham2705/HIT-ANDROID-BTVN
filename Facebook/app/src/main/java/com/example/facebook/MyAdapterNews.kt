package com.example.facebook

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.recyclerview.widget.RecyclerView

class MyAdapterNews : RecyclerView.Adapter<MyAdapterNews.ViewHolderNews>() {
    private var k : Int = 10
    class ViewHolderNews(item : View) : RecyclerView.ViewHolder(item) {
        val item_erase = item.findViewById<ImageView>(R.id.erase)

    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MyAdapterNews.ViewHolderNews {
        return ViewHolderNews(LayoutInflater.from(parent.context).inflate(R.layout.item_recy_news,parent,false))
    }

    override fun onBindViewHolder(holder: MyAdapterNews.ViewHolderNews, position: Int) {
        Log.e("key", position.toString())
        holder.item_erase.setOnClickListener {
            k--
            notifyItemRemoved(position)
            notifyItemRangeChanged(position,k-position)
        }
    }

    override fun getItemCount(): Int = k
}