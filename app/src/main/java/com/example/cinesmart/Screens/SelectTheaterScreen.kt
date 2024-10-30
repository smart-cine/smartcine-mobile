package com.example.cinesmart.Screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
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
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.cinesmart.Components.CinemaLogoComponent
import com.example.cinesmart.Components.ListCinema
import com.example.cinesmart.Components.ListTypeCinema
import com.example.cinesmart.Components.TopBarTitleAndReturnButton
import com.example.cinesmart.Components.hideSystemNavBars
import com.example.cinesmart.Navigation.CineSmartNavController
import com.example.cinesmart.ui.theme.LocalAppColor
import com.example.cinesmart.ui.theme.LocalAppPadding
import com.example.cinesmart.ui.theme.LocalAppTypography

@Composable
fun SelectTheaterScreen(mainNavHostController:CineSmartNavController){
    hideSystemNavBars()
    Scaffold(
        topBar = {
            TopBarTitleAndReturnButton(title = "Cinema Selection", modifier = Modifier
                .background(
                    LocalAppColor.current.backgroundColorDarkHeader
                )
                .padding(
                    top = LocalAppPadding.current.top_app_padding.dp,
                    bottom = LocalAppPadding.current.rounded_app_padding.dp,
                    start = LocalAppPadding.current.rounded_app_padding.dp,
                    end = LocalAppPadding.current.rounded_app_padding.dp
                ), mainNavHostController = mainNavHostController)
        }
    ) {innerPadding->
        Column(
            modifier = Modifier
                .background(LocalAppColor.current.backgroundColorDarkBody)
                .padding(innerPadding)
                .fillMaxSize()
        ) {
            ListTypeCinema()
            ListCinema(
                modifier = Modifier
                    .padding(LocalAppPadding.current.rounded_app_padding.dp)
                    .clip(
                        RoundedCornerShape(10.dp)
                    )
                    .background(
                        LocalAppColor.current.backgroundColorDarkHeader
                    )
                    .padding(LocalAppPadding.current.rounded_app_padding.dp),
                mainNavHostController = mainNavHostController)

        }
    }
}


//@Preview
//@Composable
//fun PreviewSelectTheaterScreenComponent(){
//    ListCinema()
//}