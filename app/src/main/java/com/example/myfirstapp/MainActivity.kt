package com.example.myfirstapp

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.TextView

private val TAG: String = MainActivity::class.java.getSimpleName()

class MainActivity : AppCompatActivity() {
    lateinit var etName: EditText
    lateinit var tvName: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        etName = findViewById(R.id.etName)
        tvName = findViewById(R.id.tvName)
        Log.d(TAG, "------")
        Log.d(TAG, "onCreate")
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy")
    }

    fun clickHandler(view: View) {
        startCounterActivity()
        //startDialer()
        //startEmail()

    }

    private fun startEmail() {
        var emailIntent = Intent(Intent.ACTION_SEND).apply {
            type = "text/plain"
            putExtra(Intent.EXTRA_EMAIL, "sod2003@gmail.com")
            putExtra(Intent.EXTRA_SUBJECT, "Hi")
            putExtra(Intent.EXTRA_TEXT, "Hi, Sean!")
        }
        startActivity(emailIntent)
    }

    private fun startDialer() {
        var dialIntent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:8675309")) //implicit intent
        startActivity(dialIntent)
    }

    private fun startCounterActivity() {
        var intent = Intent(this, activity_counter::class.java) //explicit Intent
        var name = etName.text.toString()
        //tvName.setText(name)
        intent.putExtra("nkey", name)
        startActivityForResult(intent, 123)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, dataIntent: Intent?) {
        super.onActivityResult(requestCode, resultCode, dataIntent)
        var contact = dataIntent?.getStringExtra("ckey")
        tvName.setText(contact)
    }
}