package com.example.cinesmart.Screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
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
import com.example.cinesmart.Components.ListBanksComponent
import com.example.cinesmart.Components.TagRankAndAge
import com.example.cinesmart.Components.TagString
import com.example.cinesmart.Components.TicketComponent
import com.example.cinesmart.Components.TopBarTitleAndReturnButton
import com.example.cinesmart.Components.hideSystemNavBars
import com.example.cinesmart.Navigation.CineSmartNavController
import com.example.cinesmart.ui.theme.LocalAppColor
import com.example.cinesmart.ui.theme.LocalAppPadding
import com.example.cinesmart.ui.theme.LocalAppTypography
import com.example.cinesmart.ui.theme.shadow



@Composable
fun PaymentScreen(mainNavHostController:CineSmartNavController) {
    hideSystemNavBars()
    Scaffold(
        topBar = {
            TopBarTitleAndReturnButton(
                title = "Pay for tickets",
                modifier = Modifier
                    .background(LocalAppColor.current.backgroundColorDarkHeader)
                    .padding(
                        top = LocalAppPadding.current.top_app_padding.dp,
                        start = LocalAppPadding.current.rounded_app_padding.dp,
                        end = LocalAppPadding.current.rounded_app_padding.dp,
                        bottom = LocalAppPadding.current.rounded_app_padding.dp
                    ),
                mainNavHostController = mainNavHostController
            )
        },
    ) { innerPadding ->
        Column(modifier = Modifier.background(LocalAppColor.current.backgroundColorDarkBody).fillMaxSize(), verticalArrangement = Arrangement.Center) {

            TicketComponent(
                modifier = Modifier
                    .background(LocalAppColor.current.backgroundColorDarkBody)
                    .padding(innerPadding)
            )
            ListBanksComponent(mainNavHostController = mainNavHostController)
        }
    }
}


//@Preview
//@Composable
//fun PreviewPaymentScreen() {
//    PaymentScreen()
//}