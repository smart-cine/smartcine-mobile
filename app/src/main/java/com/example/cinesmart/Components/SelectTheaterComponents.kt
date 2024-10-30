package com.example.cinesmart.Components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.KeyboardArrowRight
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.cinesmart.Navigation.CineSmartNavController
import com.example.cinesmart.Screens.Screens
import com.example.cinesmart.ui.theme.LocalAppColor
import com.example.cinesmart.ui.theme.LocalAppPadding
import com.example.cinesmart.ui.theme.LocalAppTypography


@Composable
fun ListCinema(modifier: Modifier = Modifier, mainNavHostController: CineSmartNavController) {
    val listCinema = listOf(1,2,3,4,5,6,7,8,9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20)
    LazyColumn(modifier = modifier) {
        itemsIndexed(listCinema){index, item->
            CinemaSelectionItem(
                Modifier.clip(RoundedCornerShape(10.dp)).clickable { mainNavHostController.navController.navigate(
                    Screens.SelectFilmPerTheaterScreen.route) }.padding(
                LocalAppPadding.current.rounded_app_padding.dp
            ))
        }
    }
}

@Composable
fun CinemaSelectionItem(modifier: Modifier = Modifier) {
    val cinemaName = "Beta Tran Quang Khai"
    Row(modifier = modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.SpaceBetween) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            AsyncImage(model = "https://play-lh.googleusercontent.com/nxo4BC4BQ5hXuNi-UCdPM5kC0uZH1lq7bglINlWNUA_v8yMfHHOtTjhLTvo5NDjVeqx-", contentDescription = "", modifier = Modifier.size(50.dp
            ))
            Spacer(modifier = Modifier.padding(LocalAppPadding.current.rounded_app_padding.dp))
            Text(text = cinemaName, style = LocalAppTypography.current.text_16_bold, color = LocalAppColor.current.textColorLight)
        }
        Icon(imageVector = Icons.Rounded.KeyboardArrowRight, contentDescription = "", tint = LocalAppColor.current.textColorLight)

    }
}

@Composable
fun ListTypeCinema() {
    val listTypeCinema = listOf(1,2,3,4,5,6,7,8,9)
    LazyRow(
        modifier = Modifier
            .padding(
                top = (2* LocalAppPadding.current.rounded_app_padding).dp,
                bottom = LocalAppPadding.current.rounded_app_padding.dp,
                start = LocalAppPadding.current.rounded_app_padding.dp,
                end = LocalAppPadding.current.rounded_app_padding.dp
            )
            .clip(RoundedCornerShape(10.dp))
            .background(
                LocalAppColor.current.backgroundColorDarkHeader
            )
            .padding(
                top = LocalAppPadding.current.rounded_app_padding.dp,
                bottom = LocalAppPadding.current.rounded_app_padding.dp,
                start = (LocalAppPadding.current.rounded_app_padding / 2).dp,
                end = (LocalAppPadding.current.rounded_app_padding / 2).dp
            )

    ) {
        item{
            CinemaLogoComponent(focus = true)
        }
        itemsIndexed(listTypeCinema) { index, item ->
            CinemaLogoComponent(false)
            CinemaLogoComponent(true)
        }
    }
}