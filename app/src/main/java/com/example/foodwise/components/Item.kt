package com.example.foodwise.components

import java.time.*

data class Item(
    val description: String,
    val price: Double,
    val date: LocalDate
    ) {
    val getDes: String
        get() = description

    val getPrice: Double
        get() = price

    val getDate: LocalDate
        get() = date

    override fun toString(): String {
        return "$description\t\t\t$$price\t\t\t$date"
    }
}
