package org.skdgt.lunchlist1

class Restaurant(private val name: String, private val address: String, private val type: String) {
    override fun toString(): String {
        return name
    }

    fun debug(): String {
        return "Restaurant(name='$name', address='$address', type='$type')"
    }
}