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
import com.example.cinesmart.Components.BottomBarPerform
import com.example.cinesmart.Components.ButtonBottomBar
import com.example.cinesmart.Components.CustomButton
import com.example.cinesmart.Components.FilmPerformInfoTopBar
import com.example.cinesmart.Components.TagRankAndAge
import com.example.cinesmart.Components.TagString
import com.example.cinesmart.Components.TopBarTitleAndReturnButton
import com.example.cinesmart.Components.TypeOfSeat
import com.example.cinesmart.Components.TypeOfSeatContainer
import com.example.cinesmart.Components.ZoomableGridDemo
import com.example.cinesmart.Components.hideSystemNavBars
import com.example.cinesmart.Navigation.CineSmartNavController
import com.example.cinesmart.ui.theme.LocalAppColor
import com.example.cinesmart.ui.theme.LocalAppPadding
import com.example.cinesmart.ui.theme.LocalAppTypography


@Composable
fun PickseatScreen(mainNavHostController:CineSmartNavController) {
    val nameCinema = "CGV Vincome Grandpark"
    hideSystemNavBars()
    Scaffold(
        topBar = {
            Column(Modifier.background(LocalAppColor.current.backgroundColorDarkHeader)) {

                TopBarTitleAndReturnButton(
                    title = nameCinema, modifier = Modifier.padding(
                        start = LocalAppPadding.current.rounded_app_padding.dp,
                        end = LocalAppPadding.current.rounded_app_padding.dp,
                        top = LocalAppPadding.current.top_app_padding.dp,
                        bottom = LocalAppPadding.current.rounded_app_padding.dp
                    ),
                    mainNavHostController = mainNavHostController
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
            BottomBarPerform(mainNavHostController = mainNavHostController)
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


//@Preview(backgroundColor = Color.BLUE.toLong())
//@Composable
//fun PreviewScreenPickseat() {
//    PickseatScreen()
//}