package com.example.myfirstapp

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*

class SignupActivity : AppCompatActivity() {
    lateinit var radioBtn: String
    lateinit var spinner : Spinner
    lateinit var country : String
    lateinit var hobbies : BooleanArray

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)
        populateSpinner()
        hobbies = booleanArrayOf(false, false, false)

    }

    fun onRadioButtonClicked(view: android.view.View) {
        if (view is RadioButton) {
            // Is the button now checked?
            val checked = view.isChecked

            // Check which radio button was clicked
            when (view.getId()) {
                R.id.radioMale ->
                    if (checked) {
                        radioBtn = "Male"
                    }
                R.id.radioFemale ->
                    if (checked) {
                        radioBtn = "Female"
                    }
            }
        }
    }

    fun populateSpinner() {
        spinner = findViewById(R.id.spinner)
        spinner.onItemSelectedListener = SpinnerActivity()
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter.createFromResource(
            this,
            R.array.countries_array,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            // Specify the layout to use when the list of choices appears
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            // Apply the adapter to the spinner
            spinner.adapter = adapter
        }

    }

    class SpinnerActivity : Activity(), AdapterView.OnItemSelectedListener {

        override fun onItemSelected(parent: AdapterView<*>, view: View?, pos: Int, id: Long) {
            // An item was selected. You can retrieve the selected item using
            parent.getItemAtPosition(pos)
        }

        override fun onNothingSelected(parent: AdapterView<*>) {
            // Another interface callback
        }
    }

    fun onCheckBoxClicked(view: android.view.View) {
        if (view is CheckBox) {
            val checked: Boolean = view.isChecked

            when (view.id) {
                R.id.checkbox_Programming    -> {
                    if (checked) {
                        hobbies[0] = true
                    } else {
                        hobbies[0] = false
                    }
                }
                R.id.checkbox_Tennis -> {
                    if (checked) {
                        hobbies[1] = true
                    } else {
                        hobbies[1] = false
                    }
                }
                R.id.checkbox_Music -> {
                    if (checked) {
                        hobbies[2] = true
                    } else {
                        hobbies[2] = false
                    }
                }
            }
        }
    }

    fun signUp(view: android.view.View) {
        var intent = Intent(this, Signup2Activity::class.java) //explicit Intent
        country = spinner.selectedItem.toString()
        intent.putExtra("name", R.id.etName)
        intent.putExtra("country", country)
        intent.putExtra("gender", radioBtn)
        intent.putExtra("hobbies", hobbies)
        startActivity(intent)
    }


}