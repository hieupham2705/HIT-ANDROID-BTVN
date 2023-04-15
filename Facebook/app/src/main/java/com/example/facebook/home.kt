package com.example.facebook

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.MediaController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.facebook.databinding.FragmentHome2Binding

class home : Fragment() {
    private val binding by lazy { FragmentHome2Binding.inflate(layoutInflater) }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding.recyclerLayoutHome.layoutManager = LinearLayoutManager(context)
        binding.recyclerLayoutHome.adapter = MyAdapterHome()
        return binding.root
    }
}