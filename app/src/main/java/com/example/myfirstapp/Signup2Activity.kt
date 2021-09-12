package com.example.myfirstapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class Signup2Activity : AppCompatActivity() {
    lateinit var tvName: TextView
    lateinit var tvGender: TextView
    lateinit var tvCountry: TextView
    lateinit var tvHobbies: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup2)

        //<---Populating Strings--->
        tvName = findViewById(R.id.tvName)
        val name = intent.getStringExtra("name")
        tvName.text = name
        tvGender = findViewById(R.id.tvGender)
        val gender = intent.getStringExtra("gender")
        tvGender.text = gender
        tvCountry = findViewById(R.id.tvCountry)
        val country = intent.getStringExtra("country")
        tvCountry.text = country

        tvHobbies = findViewById(R.id.tvHobbies)
        val hobbies = intent.getStringExtra("hobbies")
        tvHobbies.text = hobbies
    }
}