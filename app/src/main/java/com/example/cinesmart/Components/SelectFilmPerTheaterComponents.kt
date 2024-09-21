package com.example.cinesmart.Components

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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.KeyboardArrowRight
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.cinesmart.Navigation.CineSmartNavController
import com.example.cinesmart.Screens.Screens
import com.example.cinesmart.ui.theme.LocalAppColor
import com.example.cinesmart.ui.theme.LocalAppPadding
import com.example.cinesmart.ui.theme.LocalAppTypography

@Composable
fun PerformPerFilmItems(mainNavHostController: CineSmartNavController) {
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
            modifier = Modifier
                .fillMaxWidth()
                .clickable { mainNavHostController.navController.navigate(Screens.FilmInfoScreen.route) },
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
                tint = LocalAppColor.current.textColorLight,
                modifier = Modifier
                    .clickable { mainNavHostController.navController.navigate(Screens.FilmInfoScreen.route) })
        }
        Row(
            verticalAlignment = Alignment.CenterVertically, modifier = Modifier.padding(
                bottom = LocalAppPadding.current.rounded_app_padding.dp
            )
        ) {
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
                    ListPerformPerTypeCinema(
                        type = type,
                        mainNavHostController = mainNavHostController
                    )
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
fun ListPerformPerTypeCinema(type: String, mainNavHostController: CineSmartNavController) {
    val listPerformOfType = listOf(1, 2, 3, 4, 5, 6)
    for (row in 0..(listPerformOfType.size - 1) / 2) {
        Row() {
            PerformOfType(modifier = Modifier.weight(1f),mainNavHostController = mainNavHostController
            )
            PerformOfType(modifier = Modifier.weight(1f), mainNavHostController = mainNavHostController)
        }
    }
    if ((listPerformOfType.size - 1) % 2 == 1) {
        Row() {
            PerformOfType(
                modifier = Modifier.fillMaxWidth(0.5f),
                mainNavHostController = mainNavHostController
            )
        }
    }
}

@Composable
fun PerformOfType(modifier: Modifier = Modifier, mainNavHostController: CineSmartNavController) {
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
            .clickable {
                mainNavHostController.navController.navigate(Screens.PickSeatScreen.route)
            }
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