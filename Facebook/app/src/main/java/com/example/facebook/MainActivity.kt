package com.example.facebook

import android.content.Context
import android.content.Intent
import android.media.session.MediaController
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.facebook.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        replaceFragments(home())
        binding.bottomnavigation.setOnItemSelectedListener {
            when(it.itemId){
                R.id.home -> replaceFragments(home())
                R.id.watch -> replaceFragments(Watch())
                R.id.heart -> replaceFragments(Heart())
                R.id.notification -> replaceFragments(Thong_bao())
                R.id.menu -> replaceFragments(Menu())
            }
            true
        }

    }
    private fun replaceFragments(fragment: Fragment) {
        supportFragmentManager.beginTransaction().replace(R.id.framelayout,fragment).commit()
    }
}