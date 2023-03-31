package com.example.foodwise

data class Item(val description: String, val price: Double) {

    val getDes: String
        get() = description

    val getPrice: Double
        get() = price

    override fun toString(): String {
        return "$description\t\t\t$$price"
    }
}
