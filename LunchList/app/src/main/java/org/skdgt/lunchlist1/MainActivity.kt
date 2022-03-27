package org.skdgt.lunchlist1

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout

class MainActivity : AppCompatActivity() {
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

        val tabLayout = findViewById<TabLayout>(R.id.tabLayout)
        val viewPager = findViewById<ViewPager>(R.id.viewPager)

        tabLayout.addTab(tabLayout.newTab().setText("List"))
        tabLayout.addTab(tabLayout.newTab().setText("Details"))
        tabLayout.tabGravity = TabLayout.GRAVITY_FILL

        val listAdapter by lazy { RestaurantAdapter(this, android.R.layout.simple_list_item_1, rests) }
        val adapter = ViewPagerAdapter(this, supportFragmentManager, tabLayout!!.tabCount, listAdapter)
        viewPager.adapter = adapter

        viewPager.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tabLayout))

        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                viewPager.currentItem = tab.position
            }
            override fun onTabUnselected(tab: TabLayout.Tab) {

            }
            override fun onTabReselected(tab: TabLayout.Tab) {

            }
        })
    }
}