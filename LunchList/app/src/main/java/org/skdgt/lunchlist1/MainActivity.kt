package org.skdgt.lunchlist1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    private val TAG = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.setIcon(R.drawable.rest_icon)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.save_btn).setOnClickListener { _ ->
            val name = findViewById<EditText>(R.id.name_edt).text.toString()
            val address = findViewById<EditText>(R.id.address_edt).text.toString()
            val restaurant = Restaurant(name, address)

            Log.d(TAG, "onCreate: created Restaurant class:$restaurant")
        }
    }
}