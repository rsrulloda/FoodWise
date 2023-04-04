package com.example.foodwise

import android.annotation.SuppressLint
import android.os.Build
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.*
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
import com.example.foodwise.components.fooditems
import com.example.foodwise.components.items
import com.example.foodwise.ui.screens.CameraScreen
import com.example.foodwise.ui.screens.InsightScreen
import com.example.foodwise.ui.screens.InventoryScreen
import com.example.foodwise.ui.theme.FoodWiseTheme

class MainActivity : ComponentActivity() {

    // Main Function that sets bottom navigation bar
    @RequiresApi(Build.VERSION_CODES.O)
    @SuppressLint("UnusedMaterialScaffoldPaddingParameter")
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

    // Navigation controller which screen is displayed
    @RequiresApi(Build.VERSION_CODES.O)
    @Composable
    fun Navigation(navController: NavHostController) {
        NavHost(navController = navController, startDestination = "inventory") {
            composable("camera") {
                CameraScreenShow()
            }
            composable("inventory") {
                InventoryScreenShow()
            }
            composable("insight") {
                InsightScreenShow()
            }
        }
    }

    // Bottom navigation bar UI
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


    // Function that calls CameraScreen
    @Composable
    fun CameraScreenShow() {
        val instance = CameraScreen()
        instance.Display()
    }

    // Function that calls InventoryScreen
    @RequiresApi(Build.VERSION_CODES.O)
    @Composable
    fun InventoryScreenShow() {
        val instance = InventoryScreen()
        instance.Display( fooditems)
    }

    // Function that calls InsightScreen
    @Composable
    fun InsightScreenShow() {
        val instance = InsightScreen()
        instance.Display(item)
    }
}