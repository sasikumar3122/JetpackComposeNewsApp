package com.nopalsoft.newsapp

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
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
fun DetailsScreen(
    newTitle: String,
    navController: NavController,
    viewModel: DetailsScreenViewModel = hiltViewModel()
) {
    val new by viewModel.getNewsByTitle(newTitle).observeAsState(initial = null)
    DetailsScreen(newTitle, navController, new)
}


@Composable
fun DetailsScreen(
    newTitle: String,
    navController: NavController,
    new: News?,


)
{
    Scaffold(



        topBar = {
            TopAppBar(

                title = { Text(newTitle, maxLines = 1) },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(
                            imageVector = Icons.Filled.ArrowBack,
                            contentDescription = "Back",

                        )
                    }
                }
            )
        }


    )
    {
        new?.let {
            Card(
                shape = RoundedCornerShape(8.dp),
                modifier = Modifier
//                    .background(Color.Gray)
//                    .padding(8.dp)
//                    .fillMaxSize()
                    .fillMaxWidth()
                    .fillMaxHeight()
//                    .verticalScroll(rememberScrollState()),
            ) {
                Column {
                    Box(
                        Modifier
                            .fillMaxHeight()
                            .fillMaxWidth(),
//                        .background(Color.Gray),
                            contentAlignment = Alignment.BottomCenter,
                    )  {

                        Image(
                            modifier = Modifier
//                            .background(Color.Gray)
                                .fillMaxWidth()
                                .fillMaxHeight(),
//                                .fillMaxSize()
//                                .aspectRatio(16f / 9f),


                            painter = rememberImagePainter(
                                data = new.urlToImage,
                                builder = {
                                    placeholder(R.drawable.placeholder)
                                    error(R.drawable.placeholder)
                                }
                            ),
                            contentDescription = null,
                            contentScale = ContentScale.Crop

                        )

                        Column(
                            modifier = Modifier
//                                .background(Color.Gray)
//                                .padding(18.dp)
//                            .fillMaxHeight(),
//                                    contentAlignment = Alignment.BottomCenter,
                        )

                        {

                            Text(
                                new.title,
//                                fontSize = 24.sp,
                                style = MaterialTheme.typography.h1,
                                color = Color.White,
                            )
                            Box(Modifier.size(140.dp))
                            Text(new.publishedAt, color = Color.White,style = MaterialTheme.typography.h1, textAlign = TextAlign.End)
                            Box(Modifier.size(8.dp))
                            Text(new.description, color = Color.Black,fontWeight = FontWeight.Bold,style = MaterialTheme.typography.h3)
                            Box(Modifier.size(15.dp))

                        }
                    }

                }
            }
        } ?: run {

        }
    }
}



@Preview(showBackground = true)
@Composable
fun DetailsPreview() {
    NewsAppTheme {
        DetailsScreen(
            newTitle = "Hello",
            navController = rememberNavController(),
            new = News(
                "Title", "Content description", "", "",
                "https://via.placeholder.com/540x300?text=yayocode.com",
                "2022-03-21",
            "description"
            )

        )
    }
}


