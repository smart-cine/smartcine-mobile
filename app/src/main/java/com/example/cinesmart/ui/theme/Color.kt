package com.example.cinesmart.ui.theme

import androidx.compose.ui.graphics.Color

val Purple80 = Color(0xFFD0BCFF)
val PurpleGrey80 = Color(0xFFCCC2DC)
val Pink80 = Color(0xFFEFB8C8)

val Purple40 = Color(0xFF6650a4)
val PurpleGrey40 = Color(0xFF625b71)
val Pink40 = Color(0xFF7D5260)


val backgroundColorDarkHeader = Color(0xFF212738)
//val backgroundColorDarkHeader = Color(0xFF000000)

val backgroundColorDarkBody = Color(0xFF1a2232)
//val backgroundColorDarkBody = Color(0xFF161616)

val buttonColorDarkTop = Color(0xFFca6b37)
val buttonColorDarkBottom = Color(0xFFfc6d19)
val textColorOrange = Color(0xFFff8036)
val buttonColorDarkCenter = Color(0xFFfd7627)
val textColorLight = Color(0xFFFFFFFFFFFF)
val textBonusColorLight = Color(0xFF637394)
val CustomColor = _Color(
    backgroundColorDarkHeader = backgroundColorDarkHeader,
    backgroundColorDarkBody = backgroundColorDarkBody,
    buttonColorDarkTop = buttonColorDarkTop,
    buttonColorDarkBottom = buttonColorDarkBottom,
    buttonColorDarkCenter = buttonColorDarkCenter,
    textColorLight = textColorLight,
    textBonusColorLight = textBonusColorLight,
    textColorOrange = textColorOrange
)
data class _Color(
    val backgroundColorDarkHeader:Color,
    val backgroundColorDarkBody:Color,
    val buttonColorDarkTop:Color,
    val buttonColorDarkBottom:Color,
    val buttonColorDarkCenter:Color,
    val textColorLight:Color,
    val textBonusColorLight:Color,
    val textColorOrange:Color,
)
