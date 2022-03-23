package org.skdgt.lunchlist1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup

class MainActivity : AppCompatActivity() {
    private val TAG = "MainActivity"
    private val rests = arrayListOf<Restaurant>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.setIcon(R.drawable.rest_icon)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.save_btn).setOnClickListener { _ ->
            val name = findViewById<EditText>(R.id.name_edt).text.toString()
            val address = findViewById<EditText>(R.id.address_edt).text.toString()
            val typeGroup = findViewById<RadioGroup>(R.id.type_grp)
            val selectedId = typeGroup.checkedRadioButtonId

            if (selectedId == -1) {
                Log.d(TAG, "onCreate: no type selected")
            } else {
                val selectedType = findViewById<RadioButton>(selectedId).text.toString()
                val restaurant = Restaurant(name, address, selectedType)

                rests.add(restaurant)

                Log.d(TAG, "onCreate: created: ${restaurant.debug()}")
            }
        }
    }
}