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
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomNavigation
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.cinesmart.Components.DayFilterRowComponent
import com.example.cinesmart.Components.TagRankAndAge
import com.example.cinesmart.Components.TopBarTitleAndReturnButton
import com.example.cinesmart.ui.theme.LocalAppColor
import com.example.cinesmart.ui.theme.LocalAppPadding
import com.example.cinesmart.ui.theme.LocalAppTypography


@Composable
fun SelectFilmPerTheaterScreen() {
    val nameTheater = "Beta Tran Quang Khai"
    val listFilmPerCinema = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9)
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
                    )
            )
        }
    ) { innerPadding ->
        Scaffold(
            modifier = Modifier.padding(innerPadding),
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
                    PerformPerFilmItems()
                }
            }
        }

    }

}

@Composable
fun PerformPerFilmItems() {
    val filmName = "Deadpool and Wolverine"
    val filmPoster = ""
    val filmTrailer = ""
    val restrict_age = 16
    val tag = "Comedy, Action"
    val listPerform = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    val listTypeCinema = listOf("2D Sub", "3D Sub")
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(LocalAppPadding.current.rounded_app_padding.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = filmName,
                style = LocalAppTypography.current.text_18_bold,
                color = LocalAppColor.current.textColorLight
            )
            Icon(
                imageVector = Icons.Rounded.KeyboardArrowRight,
                contentDescription = "",
                modifier = Modifier.clickable { })
        }
        Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.padding(
            bottom = LocalAppPadding.current.rounded_app_padding.dp
        )) {
            TagRankAndAge(restrict_age = restrict_age)
            Text(
                text = tag,
                style = LocalAppTypography.current.text_14_normal,
                color = LocalAppColor.current.textBonusColorLight,
                modifier = Modifier.padding(start = LocalAppPadding.current.rounded_app_padding.dp)
            )
        }
        Row {
            Column(modifier = Modifier.weight(2f)) {
                AsyncImage(
                    model = "https://m.media-amazon.com/images/I/818hyvdVfvL._AC_UF894,1000_QL80_.jpg",
                    contentDescription = "",
                    modifier = Modifier
                        .fillMaxWidth()
                        .aspectRatio(0.7f),
                    contentScale = ContentScale.Crop
                )
            }
            Column(
                modifier = Modifier
                    .weight(5f)
            ) {
                for (type in listTypeCinema) {
                    Text(
                        text = type,
                        style = LocalAppTypography.current.text_18_bold,
                        color = LocalAppColor.current.textColorLight,
                        modifier = Modifier.padding(
                            start = LocalAppPadding.current.rounded_app_padding.dp,
                            end = LocalAppPadding.current.rounded_app_padding.dp,
                        )
                    )
                    ListPerformPerTypeCinema(type = type)
                    Spacer(modifier = Modifier.padding(bottom = LocalAppPadding.current.rounded_app_padding.dp))
                }
            }
        }
        Box(
            modifier = Modifier
                .padding(LocalAppPadding.current.rounded_app_padding.dp)
                .background(
                    LocalAppColor.current.textBonusColorLight
                )
        )
    }
}

@Composable
fun ListPerformPerTypeCinema(type: String) {
    val listPerformOfType = listOf(1, 2, 3, 4, 5, 6)
    for (row in 0..(listPerformOfType.size - 1) / 2) {
        Row() {
            PerformOfType(modifier = Modifier.weight(1f))
            PerformOfType(modifier = Modifier.weight(1f))
        }
    }
    if ((listPerformOfType.size - 1) % 2 == 1) {
        Row() {
            PerformOfType(modifier = Modifier.fillMaxWidth(0.5f))
        }
    }
}

@Composable
fun PerformOfType(modifier: Modifier = Modifier) {
    val startTime = "20:25"
    val endTime = "22:28"
    Row(
        verticalAlignment = Alignment.Bottom,
        modifier = modifier
            .clip(RoundedCornerShape(10.dp))
            .padding(
                top = LocalAppPadding.current.rounded_app_padding.dp,
                start = LocalAppPadding.current.rounded_app_padding.dp
            )

            .background(
                LocalAppColor.current.backgroundColorDarkHeader
            )
            .border(1.dp, LocalAppColor.current.textBonusColorLight, RoundedCornerShape(10.dp))
            .padding(
                top = LocalAppPadding.current.rounded_app_padding.dp,
                bottom = LocalAppPadding.current.rounded_app_padding.dp,
                start = (2 * LocalAppPadding.current.rounded_app_padding).dp,
                end = (2 * LocalAppPadding.current.rounded_app_padding).dp,
            )
    ) {
        Text(
            text = startTime,
            style = LocalAppTypography.current.text_18_bold,
            color = LocalAppColor.current.textColorLight
        )
        Text(
            text = " ~ $endTime",
            style = LocalAppTypography.current.text_12_bold,
            color = LocalAppColor.current.textBonusColorLight
        )
    }
}

@Preview
@Composable
fun SelectFilmPerTheaterScreenComponents() {
    PerformPerFilmItems()
}