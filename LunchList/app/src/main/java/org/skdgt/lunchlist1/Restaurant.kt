package org.skdgt.lunchlist1

class Restaurant(val name: String, val address: String, val type: Int) {

    override fun toString(): String {
        return name
    }

    fun debug(): String {
        return "Restaurant(name='$name', address='$address', type='$type')"
    }
}