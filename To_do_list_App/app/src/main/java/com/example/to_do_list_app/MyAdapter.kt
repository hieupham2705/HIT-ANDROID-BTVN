package com.example.to_do_list_app

import android.renderscript.ScriptGroup.Binding
import android.util.Log
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.to_do_list_app.databinding.ItemBinding

class MyAdapter(
    private val setOnclickDelete: (User, ArrayList<User>) -> Unit,
    private val setOnclickEdit: (User,Int) -> Unit

) : RecyclerView.Adapter<MyAdapter.ViewHolder>() {
    private var userList = arrayListOf<User>()
    class ViewHolder(val binding: ItemBinding) : RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemBinding.inflate(layoutInflater, parent, false)
        return (ViewHolder(binding))
    }

    override fun getItemCount(): Int = userList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.name.text = userList[position].name.toString()
        holder.binding.age.text = userList[position].age.toString()
        holder.binding.email.text = userList[position].email
        holder.binding.password.text = userList[position].password
        holder.binding.imgSetting.setOnClickListener {
            holder.binding.setting.visibility = View.VISIBLE
            holder.binding.delete.setOnTouchListener { view, motionEvent ->
                when (motionEvent.action) {
                    MotionEvent.ACTION_UP -> {
                        holder.binding.delete.setBackgroundResource(R.drawable.grey)
                        setOnclickDelete(userList[position], userList)
                    }
                    MotionEvent.ACTION_DOWN -> {
                        holder.binding.delete.setBackgroundResource(R.drawable.green)
                        holder.binding.setting.visibility = View.GONE
                    }
                }
                true
            }
            holder.binding.edit.setOnTouchListener { view, motionEvent ->
                when (motionEvent.action) {
                    MotionEvent.ACTION_UP -> {
                        holder.binding.edit.setBackgroundResource(R.drawable.grey)
                        setOnclickEdit(userList[position],position)
                    }
                    MotionEvent.ACTION_DOWN -> {
                        holder.binding.edit.setBackgroundResource(R.drawable.green)
                        holder.binding.setting.visibility = View.GONE
                    }
                }
                true
            }
        }
    }

    fun setList(list: ArrayList<User>) {
        userList = list
        notifyDataSetChanged()
    }

}