package org.skdgt.lunchlist1

class Restaurant(private val name: String, private val address: String) {
    override fun toString(): String {
        return "Restaurant(name='$name', address='$address')"
    }
}