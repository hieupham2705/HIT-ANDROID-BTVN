package com.example.recyclehit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclehit.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    val list = listOf<Data>(
        Data(R.drawable.img, "hiu"),
        Data(R.drawable.img, "hiu"),
        Data(R.drawable.img, "hiu"),
        Data(R.drawable.img, "hiu"),
        Data(R.drawable.img, "hiu"),
        Data(R.drawable.img, "hiu"),
        Data(R.drawable.img, "hiu"),
        Data(R.drawable.img, "hiu"),
        Data(R.drawable.img, "hiu"),
        Data(R.drawable.img, "hiu"),
        Data(R.drawable.img, "hiu"),
        Data(R.drawable.img, "hiu"),
        Data(R.drawable.img, "hiu"),
        Data(R.drawable.img, "hiu"),
        Data(R.drawable.img, "hiu"),
        Data(R.drawable.img, "hiu"),
        Data(R.drawable.img, "hiu"),
        Data(R.drawable.img, "hiu"),
        Data(R.drawable.img, "hiu"),
        Data(R.drawable.img, "hiu"),
        Data(R.drawable.img, "hiu"),
        Data(R.drawable.img, "hiu"),
        Data(R.drawable.img, "hiu"),
        Data(R.drawable.img, "hiu")
    )
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.recyclerview.layoutManager = LinearLayoutManager(this)
//        binding.recyclerview.layoutManager = GridLayoutManager(this,4,RecyclerView.HORIZONTAL,)
        binding.recyclerview.adapter = MyAdapter( list,this)

    }
}