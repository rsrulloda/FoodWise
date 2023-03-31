package com.example.foodwise

import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import android.os.Bundle
import androidx.compose.ui.res.vectorResource
import android.os.Message
import android.preference.PreferenceActivity
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.foodwise.ui.theme.FoodWiseTheme
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApp()
        }
    }

    @Preview
    @Composable
    fun MyApp() {
        val navItems = listOf(
            NavItem("Camera", Icons.Filled.Home),
            NavItem("Inventory", Icons.Filled.Favorite),
            NavItem("Insight", Icons.Filled.Person)
        )

        var selectedIndex by remember { mutableStateOf(0) }

        Scaffold(
            bottomBar = {
                BottomNavigation{
                    navItems.forEachIndexed { index, item ->
                        BottomNavigationItem(
                            icon = { Icon(item.icon, contentDescription = item.title) },
                            label = { Text(item.title) },
                            selected = selectedIndex == index,
                            onClick = { selectedIndex = index }
                        )
                    }
                }
            }
        ) { innerPadding ->
            // Content of the screen goes here

            val item1 = Item("Test Item 1", 10.50)
            val item2 = Item("Test Item 2", 13.50)
            val item3 = Item("Test Item 3", 9.75)

            val items = mutableListOf(item1, item2, item3)

            LazyColumn {
                items(items.size) { index ->
                    Text(items[index].toString(), fontSize = 20.sp)
                    Divider(color = MaterialTheme.colors.secondary, thickness = 2.dp)
                }
            }

        }
    }

    data class NavItem(val title: String, val icon: ImageVector)
}
