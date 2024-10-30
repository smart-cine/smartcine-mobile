package com.example.cinesmart.Screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.DateRange
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material.icons.rounded.PlayArrow
import androidx.compose.material.icons.rounded.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.cinesmart.Components.ButtonBottomBar
import com.example.cinesmart.Components.CustomButton
import com.example.cinesmart.Components.FilmBought
import com.example.cinesmart.Components.InfoComponent
import com.example.cinesmart.Components.TagString
import com.example.cinesmart.Components.TopBarTitleAndReturnButton
import com.example.cinesmart.Components.hideSystemNavBars
import com.example.cinesmart.Navigation.CineSmartNavController
import com.example.cinesmart.ui.theme.LocalAppColor
import com.example.cinesmart.ui.theme.LocalAppPadding
import com.example.cinesmart.ui.theme.LocalAppTypography

@Composable
fun ProfileScreen(mainNavHostController:CineSmartNavController) {
    val sizeOfAvata = 70
    var sizeOfAvataComponent = 0
    val userName = "Phung Xuan Giap"
    val listFilmBought = listOf(1,2,3,4,5,6,7,8,9,10)
    hideSystemNavBars()
    Scaffold(
        topBar = {
            TopBarTitleAndReturnButton(
                title = "Profile", modifier = Modifier
                    .background(
                        LocalAppColor.current.backgroundColorDarkHeader
                    )
                    .padding(top = LocalAppPadding.current.top_app_padding.dp),
                mainNavHostController = mainNavHostController
            )
        },
        modifier = Modifier.fillMaxSize()
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .background(LocalAppColor.current.backgroundColorDarkBody)
        ) {
            Column {
                Spacer(modifier = Modifier.padding(LocalAppPadding.current.top_app_padding.dp))
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(LocalAppPadding.current.rounded_app_padding.dp)
                        .background(LocalAppColor.current.backgroundColorDarkHeader),
                    contentAlignment = Alignment.TopCenter
                ) {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        AsyncImage(
                            model = "https://chiemtaimobile.vn/images/companies/1/%E1%BA%A2nh%20Blog/avatar-facebook-dep/Anh-avatar-hoat-hinh-de-thuong-xinh-xan.jpg?1704788263223",
                            contentDescription = "",
                            modifier = Modifier
                                .size(sizeOfAvata.dp)
                                .offset(y = (-sizeOfAvata / 2).dp)
                                .clip(CircleShape)
                        )
                        Text(
                            text = userName,
                            style = LocalAppTypography.current.text_24_bold,
                            color = LocalAppColor.current.textColorLight,
                            modifier = Modifier.offset(y = -(sizeOfAvata / 4).dp)
                        )
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            InfoComponent(icon = Icons.Rounded.DateRange, "Tickets", 0)
                            InfoComponent(icon = Icons.Rounded.PlayArrow, "Movies", 12)
                            InfoComponent(icon = Icons.Rounded.Star, "Ratings", 3)
                            InfoComponent(icon = Icons.Rounded.Email, "Ratings", 3)
                        }
                    }

                }
                if (listFilmBought.isEmpty()) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier
                            .padding(
                                LocalAppPadding.current.rounded_app_padding.dp
                            )
                            .background(LocalAppColor.current.backgroundColorDarkHeader)
                            .padding(LocalAppPadding.current.rounded_app_padding.dp)
                    ) {
                        Spacer(modifier = Modifier.padding(LocalAppPadding.current.rounded_app_padding.dp))

                        Text(text = "You have no activity on CineSmart Cinema this year.", style = LocalAppTypography.current.text_18_bold, color = LocalAppColor.current.textColorLight, textAlign = TextAlign.Center)
                        Spacer(modifier = Modifier.padding(LocalAppPadding.current.rounded_app_padding.dp))
                        Text(text = "Buy tickets, comment and rate movies to build a cool cinema profile with MoMo", style = LocalAppTypography.current.text_14_normal, color = LocalAppColor.current.textColorLight, textAlign = TextAlign.Center)
                        Spacer(modifier = Modifier.padding(LocalAppPadding.current.rounded_app_padding.dp))

                        ButtonBottomBar("Select Movies")
                        Spacer(modifier = Modifier.padding(LocalAppPadding.current.rounded_app_padding.dp))

                    }
                }
                LazyColumn(
                    modifier = Modifier
                        .padding(LocalAppPadding.current.rounded_app_padding.dp)
                        .background(LocalAppColor.current.backgroundColorDarkHeader)
                        .fillMaxHeight()
                ) {
                    itemsIndexed(listFilmBought) { index, item ->
                        FilmBought("BatMan", "CGV", "H3", "Mon", "15/7/2024")
                    }
                }
            }
        }
    }
}


//
//@Preview
//@Composable
//fun PreviewProfileComponent() {
//    ProfileScreen()
//}