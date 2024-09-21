package com.example.cinesmart.Components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
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
import com.example.cinesmart.ui.theme.shadow


@Composable
fun TicketComponent(modifier: Modifier = Modifier) {

    val cinemaName = "CGV Vincom Mega Mall Grand Park"
    val nameFilm = "The Batman"
    val restrictAge = 16
    val startTime = "17:15"
    val endTime = "19:18"
    val day = "Sat, 17/08/2024"
    val typeCinema = "2D Dub"
    val cinemaRoom = "Cinema 2"
    val seatName = "G09"

    Column(
        modifier = modifier
            .padding(
                start = LocalAppPadding.current.rounded_app_padding.dp,
                top = (2 * LocalAppPadding.current.rounded_app_padding).dp,
                end = LocalAppPadding.current.rounded_app_padding.dp,
                bottom = LocalAppPadding.current.rounded_app_padding.dp,
            )
            .clip(RoundedCornerShape(20.dp))
            .background(LocalAppColor.current.textBonusColorLight)
    ) {
        Row(
            modifier = Modifier.padding((2 * LocalAppPadding.current.rounded_app_padding).dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            AsyncImage(
                model = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcShnm2jM8GvG3v19R8DcPRKft9ZphFDxaAWtw&s",
                contentDescription = "",
                modifier = Modifier
                    .weight(2f)
                    .aspectRatio(.8f)
                    .shadow(
                        RoundedCornerShape(0.dp),
                        LocalAppColor.current.textColorOrange,
                        5.dp,
                        0.dp,
                        0.dp,
                        0.dp
                    ),

                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.padding(start = LocalAppPadding.current.rounded_app_padding.dp))
            Column(modifier = Modifier.weight(5f)) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    AsyncImage(
                        model = "https://downloadlogomienphi.com/sites/default/files/logos/download-logo-vector-cgv-mien-phi.jpg",
                        contentDescription = "",
                        modifier = Modifier
                            .padding(end = LocalAppPadding.current.rounded_app_padding.dp)
                            .size(50.dp)

                            .clip(
                                RoundedCornerShape(6.dp)
                            )
                    )
                    Text(
                        text = cinemaName,
                        style = LocalAppTypography.current.text_16_bold,
                        color = LocalAppColor.current.textColorLight,
                    )
                }
                Spacer(modifier = Modifier.padding(top = LocalAppPadding.current.rounded_app_padding.dp))
                Text(
                    text = nameFilm,
                    style = LocalAppTypography.current.text_24_bold,
                    color = LocalAppColor.current.textColorLight
                )
                Spacer(modifier = Modifier.padding(top = LocalAppPadding.current.rounded_app_padding.dp))
                TagRankAndAge(restrict_age = restrictAge)

            }
        }
        SeparateTicketPartComponent()
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding((2 * LocalAppPadding.current.rounded_app_padding).dp)
        ) {
            Row() {

                Column(
                    modifier = Modifier.weight(1f),
                ) {
                    Text(
                        text = "Format",
                        style = LocalAppTypography.current.text_16_bold,
                        color = LocalAppColor.current.textColorLight,
                        modifier = Modifier.padding(bottom = LocalAppPadding.current.rounded_app_padding.dp)
                    )
                    TagString(seatName = typeCinema)
                }
                Column(
                    modifier = Modifier.weight(1f),
                ) {
                    Text(
                        text = "Showtime",
                        style = LocalAppTypography.current.text_16_bold,
                        color = LocalAppColor.current.textColorLight,
                        modifier = Modifier.padding(bottom = LocalAppPadding.current.rounded_app_padding.dp)
                    )
                    TagString(seatName = startTime + "~" + endTime)
                    Spacer(modifier = Modifier.padding(bottom = (LocalAppPadding.current.rounded_app_padding / 2).dp))
                    TagString(seatName = day)
                }
            }
            Spacer(modifier = Modifier.padding(LocalAppPadding.current.rounded_app_padding.dp))
            Row() {
                Column(
                    modifier = Modifier.weight(1f),
                ) {
                    Text(
                        text = "Cinema Room",
                        style = LocalAppTypography.current.text_16_bold,
                        color = LocalAppColor.current.textColorLight,
                        modifier = Modifier.padding(bottom = LocalAppPadding.current.rounded_app_padding.dp)
                    )
                    TagString(seatName = cinemaRoom)
                }
                Column(
                    modifier = Modifier.weight(1f),
                ) {
                    Text(
                        text = "Seat",
                        style = LocalAppTypography.current.text_16_bold,
                        color = LocalAppColor.current.textColorLight,
                        modifier = Modifier.padding(bottom = LocalAppPadding.current.rounded_app_padding.dp)
                    )
                    TagString(seatName = seatName)
                }
            }
        }
    }
}

@Composable
fun SeparateTicketPartComponent(modifier: Modifier = Modifier.fillMaxWidth()) {
    //TODO: Fix Half circle
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Circle(size = 20, type = "head")
        Circle(size = 10)
        Circle(size = 10)
        Circle(size = 10)
        Circle(size = 10)
        Circle(size = 10)
        Circle(size = 10)
        Circle(size = 10)
        Circle(size = 10)
        Circle(size = 10)
        Circle(size = 10)
        Circle(size = 20, type = "tail")
    }
}


@Composable
fun Circle(size: Int, type: String = "normal") {
    val color = LocalAppColor.current.backgroundColorDarkBody
    if (type == "head") {
        Box(
            modifier = Modifier
                .width(size.dp)
                .height((2 * size).dp)
                .clip(RoundedCornerShape(topEnd = size.dp, bottomEnd = size.dp))
                .background(LocalAppColor.current.backgroundColorDarkBody)

        )
    } else if (type == "tail") {
        Box(

            modifier = Modifier
                .width(size.dp)
                .height((2 * size).dp)
                .clip(RoundedCornerShape(topStart = size.dp, bottomStart = size.dp))
                .background(LocalAppColor.current.backgroundColorDarkBody)

        )
    } else
        Box(
            modifier = Modifier
                .size(size.dp)
                .clip(CircleShape)
                .background(LocalAppColor.current.backgroundColorDarkBody)
        )
}

@Composable
fun ListBanksComponent(mainNavHostController: CineSmartNavController) {
    Column {
        BankComponent(
            "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSLeYoMVenMbgWL1FxDJPKuQvJD6R0KdnXE7A&s",
            "VNPAY",
            mainNavHostController = mainNavHostController
        )
        BankComponent(
            "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSsVPgwFIh0CtjqccQx6spbWxxJ-BQisfmi-sM1qPIVKMw-Vw7Q_mxAa_DjzWO5OwneXgQ&usqp=CAU",
            "MOMO" ,
            mainNavHostController = mainNavHostController

        )
        BankComponent(
            "https://cdn.haitrieu.com/wp-content/uploads/2022/10/Logo-ZaloPay-Square.png",
            "ZALO PAY",
            mainNavHostController = mainNavHostController

        )
        Spacer(modifier = Modifier.padding(bottom = LocalAppPadding.current.top_app_padding.dp))
    }
}

@Composable
fun BankComponent(image: String, name: String, mainNavHostController: CineSmartNavController) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                start = LocalAppPadding.current.rounded_app_padding.dp,
                end = LocalAppPadding.current.rounded_app_padding.dp,
                bottom = LocalAppPadding.current.rounded_app_padding.dp,
            )
            .clip(RoundedCornerShape(10.dp))
            .background(LocalAppColor.current.backgroundColorDarkHeader)
            .padding(
                LocalAppPadding.current.rounded_app_padding.dp
            )
            .clickable { mainNavHostController.navController.navigate(Screens.PaymentSuccessScreen.route) }
        , verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Center
    ) {
        AsyncImage(model = image, contentDescription = "", modifier = Modifier
            .size(40.dp)
            .clip(
                RoundedCornerShape(10.dp)
            ))
        Spacer(modifier = Modifier.padding(start = LocalAppPadding.current.rounded_app_padding.dp))
        Text(
            text = name,
            style = LocalAppTypography.current.text_16_bold,
            color = LocalAppColor.current.textColorLight
        )
    }
}
