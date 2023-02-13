package com.example.weatherappcompose.screens

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.weatherappcompose.R
import com.example.weatherappcompose.ui.theme.BlueWhite
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.pagerTabIndicatorOffset
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.launch

@Preview(showBackground = true)
@Composable
fun MainCard() {
    Column(
        modifier = Modifier
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
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            text = "20 Jun 2023 13:00",
                            style = TextStyle(fontSize = 15.sp),
                            color = Color.White,
                            modifier = Modifier.padding(start = 8.dp, top = 8.dp)
                        )
                        AsyncImage(
                            model = "https://cdn.weatherapi.com/weather/64x64/day/122.png",
                            contentDescription = "img2",
                            modifier = Modifier
                                .size(35.dp)
                                .padding(top = 3.dp, end = 8.dp)
                        )
                    }

                    Text(
                        text = "Moscow",
                        style = TextStyle(fontSize = 24.sp),
                        color = Color.White,
                    )
                    Text(
                        text = "14°C",
                        style = TextStyle(fontSize = 65.sp),
                        color = Color.White,
                    )
                    Text(
                        text = "Sunny",
                        style = TextStyle(fontSize = 16.sp),
                        color = Color.White,
                    )

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        IconButton(onClick = { /*TODO*/ }) {
                            Icon(
                                painter = painterResource(id = R.drawable.search),
                                contentDescription = "img3",
                                tint = Color.White
                            )
                        }

                        Text(
                            text = "23°C/12°C",
                            style = TextStyle(fontSize = 16.sp),
                            color = Color.White,
                        )

                        IconButton(onClick = { /*TODO*/ }) {
                            Icon(
                                painter = painterResource(id = R.drawable.sync),
                                contentDescription = "img4",
                                tint = Color.White
                            )
                        }
                    }


                }
            }
        }

    }
}

@OptIn(ExperimentalPagerApi::class)
@Composable
fun TabLayout(){
    val tabList = listOf("HOURS","DAYS")
    val pagerState = rememberPagerState()
    val tabIndex = pagerState.currentPage
    val coroutineScope = rememberCoroutineScope()

    Column(
        modifier = Modifier
            .clip(RoundedCornerShape(5.dp))
            .padding(start = 4.dp, end = 4.dp)
    ) {
        TabRow(
            selectedTabIndex = tabIndex,
            indicator = {pos ->
                        TabRowDefaults.Indicator(
                            Modifier.pagerTabIndicatorOffset(pagerState,pos)
                        )
            },
            backgroundColor = BlueWhite,
            contentColor = Color.White
        )
        {
            tabList.forEachIndexed { index, text ->
                Tab(
                    selected = false,
                    onClick = {
                              coroutineScope.launch {
                                  pagerState.animateScrollToPage(index)
                              }
                    },
                    text = {Text(text = text)},
                )
            }
        }
        HorizontalPager(
            count = tabList.size,
            state = pagerState,
            modifier = Modifier.weight(1.0f)
        ) { index ->
            LazyColumn(
                modifier = Modifier.fillMaxSize()
            ){
                items(count = 15){
                    ListItem()
                }
            }
        }
    }
}