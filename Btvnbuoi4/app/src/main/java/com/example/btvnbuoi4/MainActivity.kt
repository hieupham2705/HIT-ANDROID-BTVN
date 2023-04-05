package com.example.btvnbuoi4

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val signin : Button = findViewById(R.id.signin)
        val register : Button = findViewById(R.id.register)
        signin.setOnClickListener {
            startActivity(Intent(this,LoginScreen::class.java))
        }
        register.setOnClickListener {
            startActivity(Intent(this,RegisterScreen::class.java))
        }
    }
}