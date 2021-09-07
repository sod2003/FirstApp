package com.example.myfirstapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast

class activity_counter : AppCompatActivity() {
    lateinit var tvCounter:TextView
    var counter = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_counter)
        tvCounter = findViewById(R.id.count_initial_value)
    }

    fun updateCounter(view: View) {
        var currentValue = Integer.parseInt(tvCounter.text.toString())
        counter++
        tvCounter.setText(""+counter)
    }

    fun showToast(view: View) {
        updateCounter(view)
        Toast.makeText(this,""+counter,Toast.LENGTH_SHORT).show()
    }
}