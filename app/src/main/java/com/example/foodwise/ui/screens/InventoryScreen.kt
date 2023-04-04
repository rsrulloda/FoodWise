package com.example.foodwise.ui.screens
import android.graphics.Color.red
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.rounded.Science
import androidx.compose.material.icons.rounded.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.foodwise.components.Fooditem
import com.example.foodwise.components.fooditems

class InventoryScreen {
    @Composable
    fun Display(itemList: List<Fooditem>) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp),
        ) {
            SearchAppBar()
            Divider(
                color = Color.Gray,
                thickness = 2.dp,
                modifier = Modifier.padding(vertical = 30.dp)
            )
            LazyColumn{
                items(itemList){
                    item ->
                    SingleItemCard(item.name, item.expiration, item.image)
                    Spacer(modifier = Modifier.height(15.dp))
                }
            }
        }
    }

@Composable
fun SearchAppBar(){
    OutlinedTextField(modifier = Modifier.fillMaxWidth(), value = "", onValueChange = {}, leadingIcon = {
        Icon(imageVector = Icons.Filled.Search, contentDescription = "Search_Icon", tint = Color.Black.copy(alpha = ContentAlpha.medium))
    },
        trailingIcon = {
            IconButton(onClick = { /*TODO*/ }) {
                Icon(imageVector = Icons.Filled.Close, contentDescription = "CloseIcon", tint = Color.Red)
            }
        },
        colors = TextFieldDefaults.outlinedTextFieldColors(
            unfocusedBorderColor = Color.Black.copy(alpha = ContentAlpha.medium),
            focusedBorderColor = Color.Black,
            cursorColor = Color.Black
        ),
        placeholder = {
            Text(text = "Search...")
        }

    )
}


    @Composable
    fun TopBar(){
    Row(modifier= Modifier
        .fillMaxWidth()
        .padding(top = 7.dp),
    verticalAlignment = Alignment.CenterVertically,
    horizontalArrangement = Arrangement.SpaceBetween) {
            Text(
                text = "Grocery Items",
                fontSize = 40.sp,
                fontWeight = FontWeight.Bold,

            )
        IconButton(onClick = { /*TODO*/ }) {
            Icon(imageVector = Icons.Rounded.Search,
                contentDescription = "Search Icon",
                modifier = Modifier.size(30.dp)
            )
        }

    }
    }

    @Composable
    fun SingleItemCard(name: String, expiration: Float, image: Int){
        Card (
            elevation = 10.dp,border = BorderStroke(1.dp, Color.Blue),shape = RoundedCornerShape(size = 12.dp))
        {
            Row (
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(15.dp),
                verticalAlignment = Alignment.CenterVertically
                    ){
               Image(painter = painterResource(id = image), contentDescription = null,
                   modifier = Modifier
                       .size(80.dp)
                       .padding(10.dp),
                   contentScale = ContentScale.Fit,)
                Column(Modifier.padding(8.dp)){
                Text(text = name,
                    fontSize = 20.sp,
                modifier = Modifier.padding(10.dp))
                    Text(text = "Expiry meter :",fontSize = 15.sp)
                LinearProgressIndicator(progress = expiration, color = Color.Red)}
            }

        }
    }


    @Preview(showBackground = true)
    @Composable
    fun CameraScreenPreview() {
        Display( fooditems)
    }

}

