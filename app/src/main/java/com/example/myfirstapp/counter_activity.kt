package com.example.myfirstapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class activity_counter : AppCompatActivity() {
    lateinit var tvCounter:TextView
    var counter = 0
    lateinit var etContact: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_counter)
        tvCounter = findViewById(R.id.count_initial_value)
        etContact = findViewById(R.id.etContact)
        var name = intent.getStringExtra("nkey")
        tvCounter.setText(name)
    }

    fun updateCounter(view: View) {
        //var currentValue = Integer.parseInt(tvCounter.text.toString())
        counter++
        tvCounter.setText(""+counter)
    }

    fun showToast(view: View) {
        var contact = etContact.text.toString()
        var intent = Intent()
        intent.putExtra("ckey",contact)
        setResult(RESULT_OK,intent)
        finish()
        //updateCounter(view)
        //Toast.makeText(this,""+counter,Toast.LENGTH_SHORT).show()
    }
}