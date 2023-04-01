package com.example.foodwise

import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.material.*
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.foodwise.components.Item
import com.example.foodwise.ui.theme.FoodWiseTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FoodWiseTheme {
                val navController = rememberNavController()
                Scaffold(
                    bottomBar = {
                        BottomNavigationBar(
                            items = listOf(
                                BottomNavItem(
                                    name = "Camera",
                                    route = "camera",
                                    icon = Icons.Default.PhotoCamera
                                ),
                                BottomNavItem(
                                    name = "Inventory",
                                    route = "inventory",
                                    icon = Icons.Default.List
                                ),
                                BottomNavItem(
                                    name = "Insight",
                                    route = "insight",
                                    icon = Icons.Default.Lightbulb
                                ),
                            ),
                            navController = navController,
                            onItemClick = { navController.navigate(it.route) }
                        )
                    }
                ) { Navigation(navController = navController) }
            }
        }
    }

    @Composable
    fun Navigation(navController: NavHostController) {
        NavHost(navController = navController, startDestination = "inventory") {
            composable("camera") {
                CameraScreen()
            }
            composable("inventory") {
                InventoryScreen()
            }
            composable("insight") {
                InsightScreen()
            }
        }
    }

    @Composable
    fun BottomNavigationBar(
        items: List<BottomNavItem>,
        navController: NavController,
        modifier: Modifier = Modifier,
        onItemClick: (BottomNavItem) -> Unit
    ) {
        val backStackEntry = navController.currentBackStackEntryAsState()
        BottomNavigation(
            modifier = modifier,
            backgroundColor = Color.DarkGray,
            elevation = 5.dp
        ) {
            items.forEach { item ->
                val selected = item.route == backStackEntry.value?.destination?.route
                BottomNavigationItem(
                    selected = selected,
                    onClick = { onItemClick(item) },
                    selectedContentColor = Color.White,
                    unselectedContentColor = Color.Gray,
                    icon = {
                        Column(horizontalAlignment = CenterHorizontally) {
                            Icon(
                                imageVector = item.icon,
                                contentDescription = item.name
                            )
                            if (selected) {
                                Text(
                                    text = item.name,
                                    textAlign = TextAlign.Center,
                                    fontSize = 10.sp
                                )
                            }
                        }
                    }
                )
            }
        }
    }


    @Composable
    fun CameraScreen() {
        // Content of screen below
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Text(text = "Camera screen")
        }
        // Content of screen above
    }

    @Composable
    fun InventoryScreen() {
        // Content of screen below
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
        // Content of screen above
    }

    @Composable
    fun InsightScreen() {
        // Content of screen below
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Text(text = "Insight screen")
        }
        // Content of screen above
    }
}
