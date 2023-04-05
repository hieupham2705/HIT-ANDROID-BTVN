package com.example.btvnbuoi4

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.InputType
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView

class HomeScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_screen)
        val continuee = findViewById<Button>(R.id.continuee)
        var email = findViewById<EditText>(R.id.setemail)
        var pass = findViewById<EditText>(R.id.setpass)
        var register = intent.getParcelableExtra<Datacreateacc>("key")
        continuee.setOnClickListener {
            startActivity(Intent(this,Hihi::class.java))
        }
        val check : String = intent.getStringExtra("email").toString()
        if(check == "hieupham2705")
        {
            email.setText((intent.getStringExtra("email")).toString())
            pass.setText((intent.getStringExtra("pass")).toString())

        }
        else {
            if (register != null) {
                email.setText(register.email)
            }
            if (register != null) {
                pass.setText(register.pass)
            }
        }
        val eye = findViewById<ImageView>(R.id.eye)
        val uneye = findViewById<ImageView>(R.id.uneye)
        eye.setOnClickListener {
            pass.inputType = InputType.TYPE_TEXT_VARIATION_EMAIL_ADDRESS
            eye.visibility = View.GONE
            uneye.visibility = View.VISIBLE
        }
        uneye.setOnClickListener {
            pass.inputType = InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD
            uneye.visibility = View.GONE
            eye.visibility = View.VISIBLE
        }
    }
}