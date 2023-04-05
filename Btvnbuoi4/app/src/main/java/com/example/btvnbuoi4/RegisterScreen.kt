package com.example.btvnbuoi4

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.InputType
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout

class RegisterScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register_screen)
        val intent = Intent(this,HomeScreen::class.java)
        var username : String
        var email : String
        var pass : String
        var cfpass : String
        var text = findViewById<TextView>(R.id.settext)
        var editText = listOf<EditText>(
            findViewById(R.id.editTextTextPersonName),
            findViewById(R.id.editTextTextEmail),
            findViewById(R.id.editTextTextPassword),
            findViewById(R.id.editTextTextCfPassword)
        )
        val signup = findViewById<Button>(R.id.signup)
        signup.setOnClickListener {
            username = editText[0].text.toString()
            email = editText[1].text.toString()
            pass = editText[2].text.toString()
            cfpass = editText[3].text.toString()
            if(pass!=cfpass)
                text.text = "Password incorrect"
            else {
                text.text = ""
                intent.putExtra("key",Datacreateacc(username,email,pass,cfpass))
                startActivity(intent)
            }
        }
        val list = listOf<ConstraintLayout>(
            findViewById(R.id.signupwithfb),
            findViewById(R.id.signupwithgg)
        )
        for (item in list){
            item.setOnClickListener { startActivity(Intent(this,Hihi::class.java)) }
        }
        val login = findViewById<TextView>(R.id.login)
        login.setOnClickListener {
            startActivity(Intent(this,LoginScreen::class.java))
        }
        val eye = findViewById<ImageView>(R.id.eye)
        val uneye = findViewById<ImageView>(R.id.uneye)
        eye.setOnClickListener {
            editText[2].inputType = InputType.TYPE_TEXT_VARIATION_EMAIL_ADDRESS
            eye.visibility = View.GONE
            uneye.visibility = View.VISIBLE
        }
        uneye.setOnClickListener {
            editText[2].inputType = InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD
            uneye.visibility = View.GONE
            eye.visibility = View.VISIBLE
        }
        val eye1 = findViewById<ImageView>(R.id.eye1)
        val uneye1 = findViewById<ImageView>(R.id.uneye1)
        eye1.setOnClickListener {
            editText[3].inputType = InputType.TYPE_TEXT_VARIATION_EMAIL_ADDRESS
            eye1.visibility = View.GONE
            uneye1.visibility = View.VISIBLE
        }
        uneye1.setOnClickListener {
            editText[3].inputType = InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD
            uneye1.visibility = View.GONE
            eye1.visibility = View.VISIBLE
        }

    }
}