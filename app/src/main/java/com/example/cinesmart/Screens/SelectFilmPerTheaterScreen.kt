package com.example.cinesmart.Screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.KeyboardArrowRight
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.cinesmart.Components.DayFilterRowComponent
import com.example.cinesmart.Components.PerformPerFilmItems
import com.example.cinesmart.Components.TagRankAndAge
import com.example.cinesmart.Components.TopBarTitleAndReturnButton
import com.example.cinesmart.Components.hideSystemNavBars
import com.example.cinesmart.Navigation.CineSmartNavController
import com.example.cinesmart.ui.theme.LocalAppColor
import com.example.cinesmart.ui.theme.LocalAppPadding
import com.example.cinesmart.ui.theme.LocalAppTypography


@Composable
fun SelectFilmPerTheaterScreen(mainNavHostController: CineSmartNavController) {
    val nameTheater = "Beta Tran Quang Khai"
    val listFilmPerCinema = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9)
    hideSystemNavBars()
    Scaffold(
        topBar = {
            TopBarTitleAndReturnButton(
                title = nameTheater, modifier = Modifier
                    .background(
                        LocalAppColor.current.backgroundColorDarkHeader
                    )
                    .padding(
                        top = LocalAppPadding.current.top_app_padding.dp,
                        bottom = LocalAppPadding.current.rounded_app_padding.dp,
                        start = LocalAppPadding.current.rounded_app_padding.dp,
                        end = LocalAppPadding.current.rounded_app_padding.dp
                    ),
                mainNavHostController = mainNavHostController
            )
        }
    ) { innerPadding ->
        Scaffold(
            modifier = Modifier.fillMaxSize().padding(innerPadding),
            topBar = {
                Box(modifier = Modifier.background(LocalAppColor.current.backgroundColorDarkBody)) {
                    DayFilterRowComponent()
                }
            }
        ) { innerPadding ->
            LazyColumn(
                modifier = Modifier
                    .padding(innerPadding)
                    .background(LocalAppColor.current.backgroundColorDarkBody)
                    .padding(
                        LocalAppPadding.current.rounded_app_padding.dp
                    )
                    .clip(RoundedCornerShape(10.dp))
                    .background(LocalAppColor.current.backgroundColorDarkHeader)
            ) {
                itemsIndexed(listFilmPerCinema) { index, item ->
                    PerformPerFilmItems(mainNavHostController = mainNavHostController)
                }
            }
        }

    }

}



//@Preview
//@Composable
//fun SelectFilmPerTheaterScreenComponents() {
//    PerformPerFilmItems()
//}