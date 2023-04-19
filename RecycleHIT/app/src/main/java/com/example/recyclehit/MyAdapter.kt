package com.example.recyclehit

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class MyAdapter(
    private val ListUser: List<Data>,
    private val context: Context
) : RecyclerView.Adapter<MyAdapter.ViewHolder>() {
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imageView: ImageView = view.findViewById(R.id.image)
        val textView: TextView = view.findViewById(R.id.textview)
        fun set(context: Context, text: String) {
            Glide.with(context)
                .load("https://cdn.pixabay.com/photo/2021/08/02/05/17/sunflower-6515860__340.jpg")
                .into(imageView)
            textView.text = text
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_recycler, parent, false)
        )
    }

    override fun getItemCount(): Int = ListUser.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.set(context, ListUser[position].text)

    }
}