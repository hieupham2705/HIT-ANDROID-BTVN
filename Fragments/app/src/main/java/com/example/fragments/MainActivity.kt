package com.example.fragments

import android.content.ClipData.Item
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.fragments.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView
class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        replaceFragments(Home_Fragment())
        binding.bottomNavigation.setOnItemReselectedListener {
            when(it.itemId){
                R.id.menu_tap1 -> replaceFragments(Home_Fragment())
                R.id.menu_tap2 -> replaceFragments(Favorite_Fragment())
                R.id.menu_tap3 -> replaceFragments(Person_Fragment())
            }
        }
        true
    }
    private fun replaceFragments(fragment: Fragment){

        val fragmentManager = supportFragmentManager
        val fragmentTransition = fragmentManager.beginTransaction()
        fragmentTransition.replace(R.id.frame_layout,fragment)
        fragmentTransition.commit()
    }

}