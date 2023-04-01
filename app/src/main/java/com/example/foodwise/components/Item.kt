package com.example.foodwise.components

import java.util.Date

data class Item(
    val description: String,
    val price: Double,
    val date: Date
    ) {
    val getDes: String
        get() = description

    val getPrice: Double
        get() = price

    override fun toString(): String {
        return "$description\t\t\t$$price\t\t\t$date"
    }
}
