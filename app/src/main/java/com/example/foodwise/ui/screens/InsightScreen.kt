package com.example.foodwise.ui.screens

import android.view.Display
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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
        var total: Double = 0.0
        for (item in items) {
            if (item.isWasted) {
                total += item.price
            }
        }

        Column (
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text(text = "Money Wasted", fontSize = 30.sp)
            Text(text = "$total", fontSize = 20.sp)
        }

    }

    @Preview(showBackground = true)
    @Composable
    fun InsightScreenPreview() {
        Display(items)
    }
}

