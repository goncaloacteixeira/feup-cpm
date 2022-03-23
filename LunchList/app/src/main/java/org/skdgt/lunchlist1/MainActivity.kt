package org.skdgt.lunchlist1

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.widget.*

class MainActivity : AppCompatActivity() {
    private val TAG = "MainActivity"
    private val rests = arrayListOf<Restaurant>()

    inner class RestaurantAdapter(ctx: Context, rid: Int, objs: ArrayList<Restaurant>): ArrayAdapter<Restaurant>(ctx, rid, objs) {
        override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
            val row = convertView?: layoutInflater.inflate(R.layout.row, parent, false)
            val r = rests[position]
            row.findViewById<TextView>(R.id.name).text = r.name
            row.findViewById<TextView>(R.id.address).text = r.address

            val symbol = row.findViewById<ImageView>(R.id.type_img)
            when (r.type) {
                R.id.rdb_sitdown -> symbol.setImageResource(R.drawable.ball_red)
                R.id.rdb_takeout -> symbol.setImageResource(R.drawable.ball_yellow)
                R.id.rdb_delivery -> symbol.setImageResource(R.drawable.ball_green)
            }

            return row
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.setIcon(R.drawable.rest_icon)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        setContentView(R.layout.activity_main)

        val adapter by lazy { RestaurantAdapter(this, android.R.layout.simple_list_item_1, rests) }
        val restaurantList = findViewById<ListView>(R.id.restaurants_list)

        restaurantList.adapter = adapter

        restaurantList.setOnItemClickListener { adapterView, view, i, l ->
            Log.d(TAG, "onItemClickListener: ${adapter.getItem(i)}")
            val restaurant = adapter.getItem(i)
            findViewById<EditText>(R.id.name_edt).setText(restaurant?.name)
            findViewById<EditText>(R.id.address_edt).setText(restaurant?.address)
            findViewById<RadioGroup>(R.id.type_grp).check(restaurant!!.type)
        }

        findViewById<Button>(R.id.save_btn).setOnClickListener {
            val name = findViewById<EditText>(R.id.name_edt).text.toString()
            val address = findViewById<EditText>(R.id.address_edt).text.toString()
            val typeGroup = findViewById<RadioGroup>(R.id.type_grp)
            val selectedId = typeGroup.checkedRadioButtonId

            if (selectedId == -1) {
                Log.d(TAG, "onCreate: no type selected")
            } else {
                val selectedType = findViewById<RadioButton>(selectedId).text.toString()
                val restaurant = Restaurant(name, address, selectedId)

                adapter.add(restaurant)

                Log.d(TAG, "onCreate: created: ${restaurant.debug()}")
            }
        }
    }
}