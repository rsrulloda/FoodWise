package com.example.foodwise.ui.screens

import android.view.Display
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Lightbulb
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
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
        Column (modifier = Modifier
            .fillMaxSize()
            .padding(10.dp),){

            SingleItemCard()
            Spacer(modifier = Modifier.height(15.dp))
            SecondItemCard()
            Spacer(modifier = Modifier.height(15.dp))
            Meter()


    }

    }
    
    @Composable
    fun SingleItemCard(){
        Card (
            elevation = 10.dp,border = BorderStroke(1.dp, Color.Blue),shape = RoundedCornerShape(size = 12.dp)
        )
        {
            Icon(imageVector = Icons.Default.Lightbulb, contentDescription = "Search_Icon", tint = Color.Cyan)
            Row (
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(15.dp),
                verticalAlignment = Alignment.CenterVertically
            ){

                Column(Modifier.padding(8.dp)){
                    Text(text = "Recommended Recipes:", fontSize = 30.sp)
                    Text(
                        text = "\"Based on your Expiration Meter how about Preparing Tomato soup Today!!:",
                        fontSize = 20.sp,
                        modifier = Modifier.padding(10.dp))

                   }
            }

        }
    }
    @Composable
    fun SecondItemCard(){
        Card (
            elevation = 10.dp,border = BorderStroke(1.dp, Color.Blue),shape = RoundedCornerShape(size = 12.dp)
        )
        {
            Icon(imageVector = Icons.Default.Lightbulb, contentDescription = "Search_Icon", tint = Color.Cyan)
            Row (
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(15.dp),
                verticalAlignment = Alignment.CenterVertically
            ){

                Column(Modifier.padding(8.dp)){
                    Text(text = "Recommended Recipes:", fontSize = 30.sp)
                    Text(
                        text = "\"Based on your Expiration Meter how about Preparing Cheese Sandwich Today!!:",
                        fontSize = 20.sp,
                        modifier = Modifier.padding(10.dp))

                }
            }

        }
    }

    @Composable
    fun Meter(){
        Card (
            elevation = 10.dp,border = BorderStroke(1.dp, Color.Red),shape = RoundedCornerShape(size = 12.dp)
        )
        {
            Row (
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(15.dp),
                verticalAlignment = Alignment.CenterVertically
            ){

                Column(Modifier.padding(8.dp)){
                    Text(text = "Money Wasted:", fontSize = 30.sp)
                    Text(text = "$"+"4.11", fontSize = 20.sp)
                    LinearProgressIndicator(progress = 0.7f, color = Color.DarkGray)
                    Text(text = "Total Spent: $"+"24.76", fontSize = 20.sp)

                }
            }

        }
    }

    @Preview(showBackground = true)
    @Composable
    fun InsightScreenPreview() {
        Display(items)
    }
}

