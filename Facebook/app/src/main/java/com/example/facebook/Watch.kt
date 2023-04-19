package com.example.facebook

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.facebook.databinding.FragmentWatchBinding

class Watch(private val context: MyAdapterWatch) : Fragment() {
    private val binding by lazy { FragmentWatchBinding.inflate(layoutInflater) }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding.recyclerLayoutWatch.layoutManager = LinearLayoutManager(context)
        binding.recyclerLayoutWatch.adapter = MyAdapterWatch(context)
        return binding.root
    }
}