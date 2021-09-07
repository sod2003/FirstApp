package com.example.myfirstapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import kotlin.reflect.typeOf

class CalculatorActivity : AppCompatActivity() {
    lateinit var digit1: EditText
    lateinit var sign: EditText
    lateinit var digit2: EditText
    lateinit var result: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculator)
        digit1 = findViewById(R.id.et1)
        sign = findViewById(R.id.et2)
        digit2 = findViewById(R.id.et3)
        result = findViewById(R.id.result)
    }

    fun calculateRes() {
        val num1 = Integer.parseInt(digit1.toString())
        val num2 = Integer.parseInt(digit2.toString())

        when (sign.toString()) {
            "+" -> result.setText(num1 + num2)
            "-" -> result.setText(num1 - num2)
            "*" -> result.setText(num1 * num2)
            "/" -> if (num2 != 0) { result.setText(num1 + num2) }
                    else { result.setText("Can't divide by 0")}
            else -> {
                result.setText("Not a valid operation")
            }
        }

    }
}