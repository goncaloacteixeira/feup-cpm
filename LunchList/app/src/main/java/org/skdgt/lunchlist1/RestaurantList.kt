package org.skdgt.lunchlist1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView

class RestaurantList(private val listAdapter: ArrayAdapter<Restaurant>) : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_restaurant_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val restaurantList = view.findViewById<ListView>(R.id.restaurants_list)
        restaurantList.adapter = listAdapter

        restaurantList.setOnItemClickListener { adapterView, view, i, l ->
            current = listAdapter.getItem(i)
        }

        super.onViewCreated(view, savedInstanceState)
    }

}