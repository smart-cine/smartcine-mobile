package com.example.cinesmart.Components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.cinesmart.ui.theme.LocalAppColor
import com.example.cinesmart.ui.theme.LocalAppPadding
import com.example.cinesmart.ui.theme.LocalAppTypography

@Composable
fun FilmBought(nameFilm: String, cinemaName: String, seat: String, day: String, time: String) {
    Row(
        verticalAlignment = Alignment.CenterVertically, modifier = Modifier
            .fillMaxWidth()
            .padding(
                LocalAppPadding.current.rounded_app_padding.dp
            )
            .border(1.dp, LocalAppColor.current.textBonusColorLight)
            .padding(
                LocalAppPadding.current.rounded_app_padding.dp
            ), horizontalArrangement = Arrangement.SpaceBetween
    ) {

        Row(verticalAlignment = Alignment.CenterVertically) {
            AsyncImage(
                model = "https://m.media-amazon.com/images/I/818hyvdVfvL._AC_UF894,1000_QL80_.jpg",
                contentDescription = "",
                modifier = Modifier
                    .size(50.dp)
                    .clip(
                        CircleShape
                    ),
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.padding(LocalAppPadding.current.rounded_app_padding.dp))
            Column {

                Text(
                    text = nameFilm,
                    style = LocalAppTypography.current.text_18_bold,
                    color = LocalAppColor.current.textColorLight
                )
                Spacer(modifier = Modifier.padding(bottom = LocalAppPadding.current.rounded_app_padding.dp))
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(
                        text = cinemaName + " - " + seat,
                        style = LocalAppTypography.current.text_14_bold,
                        color = LocalAppColor.current.textColorLight
                    )
                    Spacer(modifier = Modifier.padding(end = LocalAppPadding.current.rounded_app_padding.dp))
                    TagString(seatName = day)
                    Spacer(modifier = Modifier.padding(end = LocalAppPadding.current.rounded_app_padding.dp))
                    TagString(seatName = time)
                }
            }

        }
        AsyncImage(
            model = "https://png.pngtree.com/png-vector/20230208/ourmid/pngtree-paid-stamp-vector-illustration-png-image_6585127.png",
            contentDescription = "",
            modifier = Modifier.size(
                50.dp
            ),
            contentScale = ContentScale.Crop
        )
    }
}

@Composable
fun InfoComponent(icon: ImageVector, type: String, num: Int) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.padding(
            LocalAppPadding.current.rounded_app_padding.dp
        )
    ) {
        Box(
            modifier = Modifier
                .wrapContentSize()
                .clip(CircleShape)
                .background(LocalAppColor.current.textBonusColorLight)
                .padding(
                    LocalAppPadding.current.rounded_app_padding
                        .dp
                )
        ) {

            Icon(
                imageVector = icon,
                contentDescription = "",
                tint = LocalAppColor.current.textColorLight
            )
        }
        Spacer(modifier = Modifier.padding(bottom = LocalAppPadding.current.rounded_app_padding.dp))
        Text(
            text = num.toString(),
            style = LocalAppTypography.current.text_24_bold,
            color = LocalAppColor.current.textColorLight,
        )
        Spacer(modifier = Modifier.padding(bottom = LocalAppPadding.current.rounded_app_padding.dp))

        Text(
            text = type,
            style = LocalAppTypography.current.text_12_bold,
            color = LocalAppColor.current.textBonusColorLight,
        )
    }
}