package com.example.btvnbuoi4

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.InputType
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet.Constraint
import kotlin.math.log

class LoginScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_screen)
        var k : Int = 0
        var emailcheck : String = "hieupham2705"
        var passcheck : String = "@hieu27052003"
        var email : String = ""
        var pass : String = ""
        var login : Button = findViewById(R.id.login)
        val inputemail : EditText = findViewById(R.id.editTextTextEmailAddress)
        var inputpass : EditText = findViewById(R.id.editTextTextPassword)
        var checkBox : CheckBox = findViewById(R.id.checkBox)
        val signup : TextView = findViewById(R.id.signup)
        val check = findViewById<TextView>(R.id.check)
        val intent = Intent(this,HomeScreen::class.java)
        checkBox.setOnClickListener {
            k++
        }
        login.setOnClickListener {
            email = inputemail.text.toString()
            pass = inputpass.text.toString()
            if(k%2==1) {
                inputemail.setText(email)
                inputpass.setText(pass)
            }
            else
            {
                inputemail.setText("")
                inputpass.setText("")
            }
            intent.putExtra("email",email)
            intent.putExtra("pass",pass)
            if(email == emailcheck && pass == passcheck) {
                check.text = ""
                startActivity(intent)
            }
            else {
                check.text = "Đố biết được mật khẩu :<<"
            }
        }
        signup.setOnClickListener {
            startActivity(Intent(this,RegisterScreen::class.java))
        }
       val list = listOf<ConstraintLayout>(
           findViewById(R.id.loginwithfb),
           findViewById(R.id.loginwithgg)
       )
        val textView = findViewById<TextView>(R.id.forgetpass)
        for (item in list){
            item.setOnClickListener { startActivity(Intent(this,Hihi::class.java)) }
        }
        textView.setOnClickListener {
            startActivity(Intent(this,Hihi::class.java))
        }
        val eye = findViewById<ImageView>(R.id.eye)
        val uneye = findViewById<ImageView>(R.id.uneye)
        eye.setOnClickListener {
            inputpass.inputType = InputType.TYPE_TEXT_VARIATION_EMAIL_ADDRESS
            eye.visibility = View.GONE
            uneye.visibility = View.VISIBLE
        }
        uneye.setOnClickListener {
            inputpass.inputType = InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD
            uneye.visibility = View.GONE
            eye.visibility = View.VISIBLE
        }

    }

}