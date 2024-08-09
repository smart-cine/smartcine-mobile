package com.example.cinesmart.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

// Set of Material typography styles to start with
val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    )
    /* Other default text styles to override
    titleLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 22.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp
    ),
    labelSmall = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Medium,
        fontSize = 11.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    )
    */
)
val CustomTypography = _Typography(
    text_18_bold = TextStyle(
        fontSize = 18.sp,
        fontWeight = FontWeight.Bold,
        fontFamily = CustomFont.pt_root_ui_font,
        lineHeight = 18.sp
    ),
    text_18_normal =  TextStyle(
        fontSize = 18.sp,
        fontWeight = FontWeight.Normal,
        fontFamily = CustomFont.pt_root_ui_font,
        lineHeight = 18.sp
    ),
    text_24_normal =  TextStyle(
        fontSize =24.sp,
        fontWeight = FontWeight.Normal,
        fontFamily = CustomFont.pt_root_ui_font,
        lineHeight = 24.sp
    ),
    text_24_bold =  TextStyle(
        fontSize =24.sp,
        fontWeight = FontWeight.Bold,
        fontFamily = CustomFont.pt_root_ui_font,
        lineHeight = 24.sp
    ),
    text_14_bold =  TextStyle(
        fontSize = 14.sp,
        fontWeight = FontWeight.Bold,
        fontFamily = CustomFont.pt_root_ui_font,
        lineHeight = 14.sp
    ),
    text_14_normal =  TextStyle(
        fontSize = 14.sp,
        fontWeight = FontWeight.Normal,
        fontFamily = CustomFont.pt_root_ui_font,
        lineHeight = 14.sp
    ),
    text_14_thin =  TextStyle(
        fontSize = 14.sp,
        fontWeight = FontWeight.Thin,
        fontFamily = CustomFont.pt_root_ui_font,
        lineHeight = 14.sp
    ),
    text_16_normal =  TextStyle(
        fontSize = 16.sp,
        fontWeight = FontWeight.Normal,
        fontFamily = CustomFont.pt_root_ui_font,
        lineHeight = 16.sp
    ),
    text_16_bold =  TextStyle(
        fontSize = 16.sp,
        fontWeight = FontWeight.Bold,
        fontFamily = CustomFont.pt_root_ui_font,
        lineHeight = 16.sp
    ),
    text_20_normal =  TextStyle(
        fontSize = 20.sp,
        fontWeight = FontWeight.Normal,
        fontFamily = CustomFont.pt_root_ui_font,
        lineHeight =20.sp
    ),
    text_20_thin =  TextStyle(
        fontSize = 20.sp,
        fontWeight = FontWeight.Thin,
        fontFamily = CustomFont.pt_root_ui_font,
        lineHeight = 20.sp
    ),
    text_12_bold =  TextStyle(
        fontSize = 12.sp,
        fontWeight = FontWeight.Bold,
        fontFamily = CustomFont.pt_root_ui_font,
        lineHeight = 12.sp
    ),
)
data class _Typography(
    val text_18_bold:TextStyle = TextStyle(),
    val text_18_normal:TextStyle = TextStyle(),
    val text_24_normal:TextStyle = TextStyle(),
    val text_24_bold:TextStyle = TextStyle(),
    val text_14_bold:TextStyle = TextStyle(),
    val text_14_normal:TextStyle = TextStyle(),
    val text_14_thin:TextStyle = TextStyle(),
    val text_16_normal:TextStyle = TextStyle(),
    val text_16_bold:TextStyle = TextStyle(),
    val text_20_normal:TextStyle = TextStyle(),
    val text_20_thin:TextStyle = TextStyle(),
    val text_12_bold:TextStyle = TextStyle()
)
