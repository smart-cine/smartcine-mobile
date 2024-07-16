package com.example.cinesmart.ui.theme

import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import com.example.cinesmart.R


data class _FontFamily(
    val pt_root_ui_font:FontFamily
)

val CustomFont = _FontFamily(
    pt_root_ui_font = FontFamily(
        Font(R.font.lato_bold, FontWeight.Bold),
        Font(R.font.lato_light, FontWeight.Light),
        Font(R.font.lato_regular, FontWeight.Normal)
    )
)