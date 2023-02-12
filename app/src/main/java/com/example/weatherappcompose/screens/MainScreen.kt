package com.example.weatherappcompose.screens

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.weatherappcompose.R
import com.example.weatherappcompose.ui.theme.BlueWhite

@Preview(showBackground = true)
@Composable
fun MainScreen(){
    Image(
        painter = painterResource(id = R.drawable.wallpaper),
        contentDescription = "background",
        modifier = Modifier.fillMaxSize(),
        contentScale = ContentScale.Crop
    )
    
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(5.dp),
    ) {
        Card(
            modifier = Modifier.fillMaxWidth(),
            backgroundColor = BlueWhite,
            elevation = 0.dp,
            shape = RoundedCornerShape(10.dp)
        ) {
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ){
                    Text(
                        text = "20 Jun 2023 13:00",
                        style = TextStyle(fontSize = 15.sp),
                        color = Color.White,
                        modifier = Modifier.padding(start = 8.dp,top = 8.dp)
                    )
                    AsyncImage(
                        model = "https://cdn.weatherapi.com/weather/64x64/day/122.png",
                        contentDescription = "img2",
                        modifier = Modifier
                            .size(35.dp)
                            .padding(top = 3.dp,end = 8.dp)
                    )
                }
            }
        }

    }
}