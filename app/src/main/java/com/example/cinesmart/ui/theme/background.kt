package com.example.cinesmart.ui.theme

import androidx.compose.foundation.Image
import com.example.cinesmart.R

data class Image(
    val normal_theme:Int,
    val logo_app:Int
)
val CustomImage = Image(
    normal_theme = R.drawable.background,
    logo_app = R.drawable.product_logo
)