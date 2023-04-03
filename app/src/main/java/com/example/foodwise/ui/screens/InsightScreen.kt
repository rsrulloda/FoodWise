package com.example.foodwise.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.foodwise.components.Item
import java.time.LocalDate

class InsightScreen {
    @Composable
    fun Display() {
        var item = Item("Beef", 25.50, LocalDate.of(2021,4,1))

        if(item.getIsWasted) {

            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Text(text = "Is not wasted" + item.toString())
            }
        }

        item.isWasted = true
        if(item.getIsWasted) {

            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.TopCenter
            ) {
                Text(text = "Wasted:" + item.toString())
            }
        }
    }
}