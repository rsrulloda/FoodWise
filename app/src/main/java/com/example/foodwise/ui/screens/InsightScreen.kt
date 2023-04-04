package com.example.foodwise.ui.screens

import android.view.Display
import androidx.compose.foundation.layout.*
import androidx.compose.material.LinearProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.foodwise.components.Item
import com.example.foodwise.components.fooditems
import com.example.foodwise.components.items
import java.time.LocalDate

class InsightScreen {

    @Composable
    fun Display(items: List<Item>) {

        // calculate the total amount of grocery wasted in dollar
        var wastedAmount: Double = 0.0
        var total: Double = 0.0
        for (item in items) {
            total += item.price
            if (item.isWasted) {

                wastedAmount += item.price
            }
        }

        val myFormattedStringWasted = String.format("%.2f", wastedAmount)
        val myFormattedStringTotal = String.format("%.2f", total)
        var percentage: Double = (total - wastedAmount)/total
        val percentageFloat = percentage.toFloat()

        val wastedAmountString = wastedAmount.toString()

        Column (
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text(text = "Money Wasted", fontSize = 30.sp)

            Text(text = "$$myFormattedStringWasted", fontSize = 20.sp)
            LinearProgressIndicator(progress = percentageFloat, color = Color.DarkGray)
            Text(text = "Total Spent: $$myFormattedStringTotal", fontSize = 20.sp)
        }

    }

    @Preview(showBackground = true)
    @Composable
    fun InsightScreenPreview() {
        Display(items)
    }
}

