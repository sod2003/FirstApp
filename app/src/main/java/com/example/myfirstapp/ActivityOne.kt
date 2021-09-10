package com.example.myfirstapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.AlarmClock
import android.util.Log
import android.widget.EditText
import android.widget.Toast

class ActivityOne : AppCompatActivity() {
    var TAG = ActivityOne::class.java.simpleName

    lateinit var etTimer: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_one)
        etTimer = findViewById(R.id.etTimer)
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

    fun setMinuteTimer(view: android.view.View) {
        Log.i(TAG, "setMinuteTimerBtn pressed")
        startTimer("Minute Timer", 60)
        Toast.makeText(this,"Minute Timer Set",Toast.LENGTH_SHORT).show()
    }

    fun set2MinuteTimer(view: android.view.View) {
        Log.i(TAG, "set2MinuteTimerBtn pressed")
        startTimer("2 Minute Timer", 120)
        Toast.makeText(this,"2 Minute Timer Set",Toast.LENGTH_SHORT).show()
    }

    fun set30SecondTimer(view: android.view.View) {
        Log.i(TAG, "set30SecondTimerBtn pressed")
        startTimer("30 Second Timer", 30)
        Toast.makeText(this,"30 Second Timer Set",Toast.LENGTH_SHORT).show()
    }

    fun setCustomTimer(view: android.view.View) {
        Log.i(TAG, "setCustomTimerBtn pressed")
        val time = etTimer.getText().toString().toInt()
        startTimer("Custom Timer", time)
        val customText = "Custom Timer set for $time seconds"
        Toast.makeText(this, customText,Toast.LENGTH_SHORT).show()
        etTimer.setText("")

    }

    fun startTimer(message: String, seconds: Int) {
        val intent = Intent(AlarmClock.ACTION_SET_TIMER).apply {
            putExtra(AlarmClock.EXTRA_MESSAGE, message)
            putExtra(AlarmClock.EXTRA_LENGTH, seconds)
            putExtra(AlarmClock.EXTRA_SKIP_UI, true)
        }
        if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent)
        }
    }


}