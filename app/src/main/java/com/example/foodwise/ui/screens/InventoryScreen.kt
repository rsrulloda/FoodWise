package com.example.foodwise.ui.screens

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Divider
import androidx.compose.material.ListItem
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.foodwise.components.Item
import java.time.LocalDate
import java.time.temporal.ChronoUnit
import java.util.*

class InventoryScreen {
    @RequiresApi(Build.VERSION_CODES.O)
    val currentDate: LocalDate = LocalDate.now()

    @RequiresApi(Build.VERSION_CODES.O)
    @Composable
    fun Display() {

        // Temporary List of Items
        val item1 = Item("Test Item 1", 10.50, LocalDate.of(2021,4,1))
        val item2 = Item("Test Item 2", 13.50, LocalDate.of(2022,4,1))
        val item3 = Item("Test Item 3", 9.75, LocalDate.of(2023,4,1))
        val item4 = Item("Test Item 4", 9.75, LocalDate.of(2024,4,1))
        val items = mutableListOf(item1, item2, item3, item4)

        // Scrollable List of Items
        LazyColumn {
            items(items.size) { index ->
                println(ChronoUnit.DAYS.between(currentDate, items[index].getDate)) // Displays how many days until expiration in console


                // Checks if item expires within 14 days, if yes then item displayed has red background
                if(ChronoUnit.DAYS.between(currentDate, items[index].getDate)>14) {
                    Text("" + items[index] + "| Date Bought: " + items[index].getDate.toString(), fontSize = 20.sp)
                    Divider(color = Color.Gray, thickness = 2.dp)
                } else {
                    Box(modifier = Modifier.background(Color.Red)) {
                        Text("" + items[index] + "| Date Bought: " + items[index].getDate.toString(), fontSize = 20.sp)
                        Divider(color = Color.Gray, thickness = 2.dp)
                    }
                }


            }
        }
    }
}