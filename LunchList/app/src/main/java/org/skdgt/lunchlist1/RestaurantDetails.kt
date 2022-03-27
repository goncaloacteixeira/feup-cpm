package org.skdgt.lunchlist1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*

class RestaurantDetails(private val listAdapter: ArrayAdapter<Restaurant>) : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_restaurant_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        view.findViewById<Button>(R.id.save_btn).setOnClickListener {
            val name = view.findViewById<EditText>(R.id.name_edt).text.toString()
            val address = view.findViewById<EditText>(R.id.address_edt).text.toString()
            val typeGroup = view.findViewById<RadioGroup>(R.id.type_grp)
            val selectedId = typeGroup.checkedRadioButtonId

            if (selectedId != -1) {
                val restaurant = Restaurant(name, address, selectedId)
                listAdapter.add(restaurant)
            }
        }

        super.onViewCreated(view, savedInstanceState)
    }
}