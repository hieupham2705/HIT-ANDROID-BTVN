package com.example.facebook
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyAdapterHome : RecyclerView.Adapter<MyAdapterHome.ViewHolderHome>() {
    class ViewHolderHome(item : View): RecyclerView.ViewHolder(item) {
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MyAdapterHome.ViewHolderHome {

        return ViewHolderHome(LayoutInflater.from(parent.context).inflate(R.layout.item_recy_home,parent,false))
    }

    override fun onBindViewHolder(holder: MyAdapterHome.ViewHolderHome, position: Int) {
    }

    override fun getItemCount(): Int {
        return 20
    }
}