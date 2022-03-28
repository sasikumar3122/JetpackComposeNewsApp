package com.nopalsoft.newsapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil.compose.rememberImagePainter
import com.nopalsoft.newsapp.model.News
import com.nopalsoft.newsapp.ui.theme.NewsAppTheme

@Composable
fun ListScreen(
    navController: NavController,
    viewModel: ListScreenViewModel = hiltViewModel()
) {
    val newsList by viewModel.getNews().observeAsState(initial = emptyList())
    ListScreen(navController, newsList)

}

@Composable
fun ListScreen(
    navController: NavController,
    news: List<News>
) {
    Scaffold(


        topBar = {
            TopAppBar(
                title = { Text("                       HEADLINES")
                        },
            )
        }

    )

    {
        LazyColumn {
            items(news) { new ->

                Card(
                    shape = RoundedCornerShape(8.dp),
                    modifier = Modifier
//                        .padding(8.dp)
                        .fillMaxWidth()
                        .background(Color.Gray)
                        .clickable {
                            navController.navigate("${Destinations.DETAILS_SCREEN}/${new.title}")
                        },
                ) {
                    Column {
                        Box(Modifier
//                            .padding(5.dp)
                            .background(Color.Gray)
                            .fillMaxSize(),
                                contentAlignment = Alignment.BottomCenter
                        ){
                            Image(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .background(Color.Gray)
                                    .aspectRatio(16f / 9f),
                                painter = rememberImagePainter(
                                    data = new.urlToImage,

                                    builder = {
                                        placeholder(R.drawable.placeholder)
                                        error(R.drawable.placeholder)

                                    }
                                ),
                                contentDescription = null,
                                contentScale = ContentScale.FillWidth
                            )

                            Box(
                                contentAlignment = Alignment.BottomStart,
                                modifier = Modifier
                                    .fillMaxSize()                        .background(Color.Gray)
                                    .background(Color.Gray)
//                    .background(Color.Gray)
                            )

                            {

                            }
                            Column(Modifier.padding(4.dp)
//                                .background(Color.Gray)

                            ){
                                Text(
                                    new.title,
//                                    fontSize = 16.sp,
                                    style = MaterialTheme.typography.h2,
                                    color = Color.White,

                                    )
                                Box(Modifier.size(10.dp))

                                Text(
                                    new.publishedAt,
                                    fontSize = 15.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = Color.White,
                                )
                                Box(Modifier.size(1.dp)
                                )

                            }
                        }

                    }


                }
            }
        }

    }
}

@Preview(showBackground = true)
@Composable
fun ListPreview() {
    NewsAppTheme {
//        Modifier .background(Color.Black)
        ListScreen(
            navController = rememberNavController(),
            news = arrayListOf(
                News(
                    "Title", "Content description", "", "",
                    "https://via.placeholder.com/540x300?text=yayocode.com",
                    "2022-03-21",
                    "description"
                ),
                News(
                    "Title2", "Content description", "", "",
                    "https://via.placeholder.com/540x300?text=yayocode.com",
                    "2022-03-21",
                    "description"
                ),
                News(
                    "Title2", "Content description", "", "",
                    "https://via.placeholder.com/540x300?text=yayocode.com",
                    "2022-03-21",
                    "description"
                )
            )
        )
    }
}