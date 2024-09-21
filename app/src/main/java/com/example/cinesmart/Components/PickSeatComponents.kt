package com.example.cinesmart.Components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.cinesmart.Navigation.CineSmartNavController
import com.example.cinesmart.Screens.Screens
import com.example.cinesmart.ui.theme.LocalAppColor
import com.example.cinesmart.ui.theme.LocalAppPadding
import com.example.cinesmart.ui.theme.LocalAppTypography


@Composable
fun BottomBarPerform(mainNavHostController: CineSmartNavController) {
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
            ButtonBottomBar("Top Up", mainNavHostController = mainNavHostController, destinationNavigation = Screens.PaymentScreen.route)
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