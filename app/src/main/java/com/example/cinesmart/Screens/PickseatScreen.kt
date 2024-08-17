package com.example.cinesmart.Screens

import android.graphics.Color
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.cinesmart.Components.ButtonBottomBar
import com.example.cinesmart.Components.CustomButton
import com.example.cinesmart.Components.FilmPerformInfoTopBar
import com.example.cinesmart.Components.TagRankAndAge
import com.example.cinesmart.Components.TagString
import com.example.cinesmart.Components.TopBarTitleAndReturnButton
import com.example.cinesmart.Components.TypeOfSeat
import com.example.cinesmart.Components.ZoomableGridDemo
import com.example.cinesmart.ui.theme.LocalAppColor
import com.example.cinesmart.ui.theme.LocalAppPadding
import com.example.cinesmart.ui.theme.LocalAppTypography


@Composable
fun PickseatScreen() {
    val nameCinema = "CGV Vincome Grandpark"
    Scaffold(
        topBar = {
            Column(Modifier.background(LocalAppColor.current.backgroundColorDarkHeader)) {

                TopBarTitleAndReturnButton(
                    title = nameCinema, modifier = Modifier.padding(
                        start = LocalAppPadding.current.rounded_app_padding.dp,
                        end = LocalAppPadding.current.rounded_app_padding.dp,
                        top = LocalAppPadding.current.top_app_padding.dp,
                        bottom = LocalAppPadding.current.rounded_app_padding.dp
                    )
                )
                FilmPerformInfoTopBar(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(
                            start = LocalAppPadding.current.rounded_app_padding.dp,
                            end = LocalAppPadding.current.rounded_app_padding.dp,
                            top = LocalAppPadding.current.rounded_app_padding.dp
                        )
                )
            }
        },
        bottomBar = {
            BottomBarPerform()
        }
    ) { innnerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(LocalAppColor.current.backgroundColorDarkBody)
                .padding(innnerPadding), horizontalAlignment = Alignment.CenterHorizontally
        ) {

            TypeOfSeatContainer(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(LocalAppColor.current.backgroundColorDarkBody)
            )
            ZoomableGridDemo()
            Box(
                modifier = Modifier
                    .width(300.dp)
                    .height(2.dp)
                    .background(LocalAppColor.current.textBonusColorLight)
            )

        }
    }
}

@Composable
fun BottomBarPerform() {
    val fee = 20000
    val seatName = "H3"
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .background(LocalAppColor.current.backgroundColorDarkHeader)
            .padding(
                start = LocalAppPadding.current.rounded_app_padding.dp,
                end = LocalAppPadding.current.rounded_app_padding.dp,
                top = LocalAppPadding.current.rounded_app_padding.dp,
                bottom = LocalAppPadding.current.top_app_padding.dp
            )
    ) {
        Column(
            modifier = Modifier,
            verticalArrangement = Arrangement.Center
        ) {
            Row(modifier = Modifier.padding(
                bottom = LocalAppPadding.current.rounded_app_padding.dp,
            ), verticalAlignment = Alignment.CenterVertically) {
                Text(text = "The Batman: "+"Seat-", style = LocalAppTypography.current.text_18_bold, color = LocalAppColor.current.textColorLight)
                TagString(seatName = seatName)
            }
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically) {
                Text(text = "Estimated", style = LocalAppTypography.current.text_14_normal, color = LocalAppColor.current.textColorLight)
                Text(text = fee.toString()+" VND", style = LocalAppTypography.current.text_18_bold, color = LocalAppColor.current.textColorLight)
            }
            Spacer(modifier = Modifier.padding(LocalAppPadding.current.rounded_app_padding.dp))
            ButtonBottomBar()
        }
    }
}

@Composable
fun TypeOfSeatContainer(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier.padding(
            LocalAppPadding.current.rounded_app_padding.dp
        ), horizontalArrangement = Arrangement.Center
    ) {
        TypeOfSeat(type = "Available")
        Spacer(modifier = Modifier.padding(LocalAppPadding.current.rounded_app_padding.dp))
        TypeOfSeat(type = "Occupied")
        Spacer(modifier = Modifier.padding(LocalAppPadding.current.rounded_app_padding.dp))
        TypeOfSeat(type = "Chosen")
    }
}

@Preview(backgroundColor = Color.BLUE.toLong())
@Composable
fun PreviewScreenPickseat() {
    PickseatScreen()
}