package com.example.myfirstapp

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.*

class SignupActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var etName: EditText
    private lateinit var radioBtn: String
    private lateinit var spinner : Spinner
    private lateinit var country : String
    private lateinit var hobbies : MutableMap<String, Boolean>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)
        etName = findViewById((R.id.etName))
        populateSpinner()
        hobbies = mapOf("Programming" to false, "Tennis" to false, "Music" to false) as MutableMap<String, Boolean>
        val button = findViewById<Button>(R.id.button)
        button.setOnClickListener(this)

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.home_menu,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.miFirst -> {
                Toast.makeText(this, "first", Toast.LENGTH_SHORT).show()
            }
            R.id.miSecond -> {
                Toast.makeText(this, "second", Toast.LENGTH_SHORT).show()
            }
            R.id.miThird -> {
                Toast.makeText(this, "third", Toast.LENGTH_SHORT).show()
            }
        }
        return true
    }

    fun onRadioButtonClicked(view: View) {
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

    private fun populateSpinner() {
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

    fun onCheckBoxClicked(view: View) {
        if (view is CheckBox) {
            val checked: Boolean = view.isChecked

            when (view.id) {
                R.id.checkbox_Programming    -> {
                    if (checked) {
                        hobbies["Programming"] = true
                    } else {
                        hobbies["Programming"] = false
                    }
                }
                R.id.checkbox_Tennis -> {
                    if (checked) {
                        hobbies["Tennis"] = true
                    } else {
                        hobbies["Tennis"] = false
                    }
                }
                R.id.checkbox_Music -> {
                    if (checked) {
                        hobbies["Music"] = true
                    } else {
                        hobbies["Music"] = false
                    }
                }
            }
        }
    }

    override fun onClick(p0: View?) {
        val intent = Intent(this, Signup2Activity::class.java) //explicit Intent
        country = spinner.selectedItem.toString()
        val name = etName.text.toString()
        intent.putExtra("name", name)
        intent.putExtra("country", country)
        intent.putExtra("gender", radioBtn)
        val hobbyString = hobbyString()
        intent.putExtra("hobbies", hobbyString)
        startActivity(intent)
    }

//    fun signUp(view: android.view.View) {
//        var intent = Intent(this, Signup2Activity::class.java) //explicit Intent
//        country = spinner.selectedItem.toString()
//        var name = etName.text.toString()
//        intent.putExtra("name", name)
//        intent.putExtra("country", country)
//        intent.putExtra("gender", radioBtn)
//        val hobbyList = hobbyString()
//        intent.putExtra("hobbies", hobbyList)
//        startActivity(intent)
//    }

    private fun hobbyString(): String {
        var commaRef = false
        var string = ""
        for (hobby in hobbies) {
            if (hobby.value) {
                if (commaRef) {
                    string = string.plus(", ")
                    commaRef = false
                }

                    string = string.plus(hobby.key)
                    commaRef = true
            }
        }

        return string
    }


}