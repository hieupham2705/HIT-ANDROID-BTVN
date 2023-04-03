package com.example.mycalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MotionEvent
import android.view.View
import android.widget.ActionMenuView
import android.widget.ImageView
import android.widget.TextView
import com.example.mycalculator.databinding.ActivityMainBinding
import org.w3c.dom.Text
import java.util.concurrent.TimeUnit
import kotlin.math.log


private  fun xuly(string : String, hiu1 : Double, hiu2 : Double): String {
    var x : Double =0.0
    if(string=="+")
        x = hiu1+hiu2
    else if(string=="-")
        x = hiu1-hiu2
    else if(string=="x")
        x = hiu1*hiu2
    else if(string=="/")
        x = hiu1/hiu2
    var y : Int = x.toInt()
    if(y.toDouble() == x) return y.toString()
    return x.toString()
}
private fun solve(firstValue : Double, secondValue : Double ,string : String) : String{
    return xuly(string[string.length-1].toString(),firstValue,secondValue);
    return "0"
}
class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater)  }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
//        var elementa : String = ""
//        var elementb : String = ""
//        var operator: String = ""
//        var sum : TextView = findViewById(R.id.sum)
//        with(binding){
//            val listnumber =  listOf(
//                a0,a1,a2,a3,a4,a5,a6,a7,a8,a9
//            )
//            val listOperator = listOf(
//                a10,a11,a12,a13,a14,a15,a16,a17,ac
//            )
//            listnumber.forEach { item ->
//                item.setOnClickListener {
//                    elementa += item.text.toString()
//                    sum.text = elementa
////                    Log.e("v","0")
//                }
//            }
//            listOperator.forEachIndexed { index, _ ->
//                when(index+1){
////                    1->
//                }
//            }
//        }
        var string : String = ""
        var firstValue : String = ""
        var secondValue : String = ""
        var k : Int = 0
        var x : Int = 0
        var text: TextView = findViewById(R.id.sum)
        var index : TextView = findViewById(R.id.a13)
        val listso = listOf<TextView>(
            findViewById(R.id.a0),
            findViewById(R.id.a1),
            findViewById(R.id.a2),
            findViewById(R.id.a3),
            findViewById(R.id.a4),
            findViewById(R.id.a5),
            findViewById(R.id.a6),
            findViewById(R.id.a7),
            findViewById(R.id.a8),
            findViewById(R.id.a9),
            findViewById(R.id.a10)
        )
        val bang : TextView = findViewById(R.id.a11)

        val listpheptinh = listOf<TextView>(
            findViewById(R.id.a12),
            findViewById(R.id.a13),
            findViewById(R.id.a14),
            findViewById(R.id.a15),
            findViewById(R.id.a16),
            findViewById(R.id.a17)
        )
        val ac : TextView =   findViewById(R.id.ac)
        for (item in listso) {
            item.setOnTouchListener { view, motionEvent ->
                when (motionEvent.action) {
                    MotionEvent.ACTION_DOWN -> {
                        if (text.text == "Lỗi"||k==10||(string.length!=0&&k==1)) {
                            if(string.length==0) {
                                firstValue = ""
//                                secondValue = ""
//                                string = ""
                            }
                            text.text = ""
                            k=0
                        }
                        if(string.length==0)
                            firstValue += item.text.toString()
                        else {
                            secondValue += item.text.toString()
                        }
                        text.text = text.text.toString() + item.text.toString()
                        item.setBackgroundResource(R.drawable.click)
                    }
                    MotionEvent.ACTION_UP -> {
                        item.setBackgroundResource(R.drawable.boder)
                        if(x==1){
                            index.setBackgroundResource(R.drawable.boderyelow)
                            x=0
                        }

                    }
                }
                true
            }
        }
        for (item in listpheptinh) {
            item.setOnTouchListener { view, motionEvent ->
                when (motionEvent.action) {
                    MotionEvent.ACTION_DOWN -> {
                        if(item.text == "%"){
                            if(text.text=="") {
                                text.text = "0"
                            }
                            else {
                                var x: Double = text.text.toString().toDouble()
                                text.text = (x / 100).toString()
                            }
                        }
                        else if(item.text == "+/-") {
                            if (text.text == "") {
                                text.text = "-0"
                            } else {
                                var x: Double = text.text.toString().toDouble()
                                text.text = (-x).toString()
                            }
                        }
                        else {
                            k=1
                            string += item.text.toString()
                            secondValue = ""
                        }
                        item.setBackgroundResource(R.drawable.click)
                    }
                    MotionEvent.ACTION_UP -> {
                        if(item.text == "+/-" || item.text == "%")
                            item.setBackgroundResource(R.drawable.boderxam)
                        else
                        {
                            index.setBackgroundResource(R.drawable.boderyelow)
                            x=1
                            index = item
                        }
                    }
                }
                true
            }
        }
        bang.setOnTouchListener { view, motionEvent ->
            when (motionEvent.action) {
                MotionEvent.ACTION_DOWN -> {
                    k=10
                    if(string.length == 0 && firstValue != "")
                    {
                        text.text = firstValue
                        firstValue = text.text.toString()
//                        secondValue = ""
                    }
                    else if(string.length !=0 && firstValue != "0" && secondValue == ""){
                        text.text =  solve(firstValue.toDouble(), firstValue.toDouble(), string).toString()
                        firstValue = text.text.toString()
//                        secondValue = ""
                        string = ""
                    }
                    else if(secondValue.toDouble() == 0.0 && string[string.length-1].toString() == "/")
                        text.text = "Lỗi"
                    else {
                        text.text = solve(firstValue.toDouble(), secondValue.toDouble(), string).toString()
                        firstValue = text.text.toString()
//                        secondValue = ""
                        string = ""
                    }
                        k=10
                        bang.setBackgroundResource(R.drawable.click)
                }
                MotionEvent.ACTION_UP -> {
                    bang.setBackgroundResource(R.drawable.boderyelow)
                    if(x==1){
                        index.setBackgroundResource(R.drawable.boderyelow)
                        x=0
                    }
                }
            }
            true
        }
        ac.setOnTouchListener { view, motionEvent ->
            when (motionEvent.action) {
                MotionEvent.ACTION_DOWN -> {
                    ac.setBackgroundResource(R.drawable.click)
                    text.text = ""
                    firstValue = ""
                    secondValue = ""
                    string = ""
                    k=0
                    x=0
                }
                MotionEvent.ACTION_UP -> {
                    ac.setBackgroundResource(R.drawable.boderxam)
                    if(x==1){
                        index.setBackgroundResource(R.drawable.boderyelow)
                        x=0
                    }
                }
            }
            true
        }

    }
}