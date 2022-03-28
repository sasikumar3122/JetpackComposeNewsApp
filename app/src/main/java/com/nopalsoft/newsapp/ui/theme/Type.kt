package com.nopalsoft.newsapp.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.nopalsoft.newsapp.R

// Set of Material typography styles to start with
val ROBOTO = FontFamily(
    Font(R.font.robotoslab_regular,FontWeight.Normal),
    Font(R.font.robotoslab_bold,FontWeight.Bold),
)

val Typography = Typography(
    h1 = TextStyle(
        fontFamily = ROBOTO,
        fontWeight = FontWeight.Bold,
        fontSize = 20.sp
    ),

    h2 = TextStyle(
        fontFamily = ROBOTO,
        fontWeight = FontWeight.Normal,
        fontSize = 20.sp
    ),
    h3 = TextStyle(
        fontFamily = ROBOTO,
        fontWeight = FontWeight.Normal,
        fontSize = 15.sp
    )

    /* Other default text styles to override
    button = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.W500,
        fontSize = 14.sp
    ),
    caption = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp
    )
    */
)