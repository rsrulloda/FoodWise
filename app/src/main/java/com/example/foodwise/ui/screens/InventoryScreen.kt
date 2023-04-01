package com.example.foodwise.ui.screens

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.foodwise.components.Item
import java.util.*

class InventoryScreen {
    @Composable
    fun Display() {
        // Content of screen below
        val item1 = Item("Test Item 1", 10.50, Date(2019))
        val item2 = Item("Test Item 2", 13.50, Date(2020))
        val item3 = Item("Test Item 3", 9.75, Date(2021))

        val items = mutableListOf(item1, item2, item3)

        LazyColumn {
            items(items.size) { index ->
            Text(items[index].toString(), fontSize = 20.sp)
                Divider(color = MaterialTheme.colors.secondary, thickness = 2.dp)
            }
        }
        // Content of screen above
    }
}