package com.nopalsoft.newsapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.nopalsoft.newsapp.ui.theme.NewsAppTheme
import dagger.hilt.android.AndroidEntryPoint

object Destinations {
    const val LIST_SCREEN = "LIST_SCREEN"
    const val DETAILS_SCREEN = "DETAILS_SCREEN"
}

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NewsAppTheme {

                Column(
                    Modifier.background(Color.Black)
                        .fillMaxSize()
                        .padding(8.dp)
                ) {

                    // A surface container using the 'background' color from the theme
                    Surface(



                    ) {
                        val navController = rememberNavController()
                        NavHost(
                            navController = navController,
                            startDestination = Destinations.LIST_SCREEN,
                        ) {
                            composable(Destinations.LIST_SCREEN) {
                                ListScreen(navController)
                            }
                            composable("${Destinations.DETAILS_SCREEN}/{newTitle}") {
                                it.arguments?.getString("newTitle")?.let { title ->
                                    DetailsScreen(title, navController)
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    NewsAppTheme {
        Greeting("Android")
    }
}