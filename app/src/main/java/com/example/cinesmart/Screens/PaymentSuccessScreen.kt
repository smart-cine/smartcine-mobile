package com.example.cinesmart.Screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.blur
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.cinesmart.Components.ButtonBottomBar
import com.example.cinesmart.Components.TicketComponent
import com.example.cinesmart.Components.TopBarTitleAndReturnButton
import com.example.cinesmart.Components.hideSystemNavBars
import com.example.cinesmart.Navigation.CineSmartNavController
import com.example.cinesmart.ui.theme.LocalAppColor
import com.example.cinesmart.ui.theme.LocalAppPadding


@Composable
fun PaymentSuccessScreen(mainNavHostController:CineSmartNavController) {
    hideSystemNavBars()
    Scaffold(
        topBar = {
            TopBarTitleAndReturnButton(
                title = "Payment Successfully", modifier = Modifier.background(LocalAppColor.current.backgroundColorDarkHeader).padding(
                    top = LocalAppPadding.current.top_app_padding.dp,
                    bottom = LocalAppPadding.current.rounded_app_padding.dp,
                    start = LocalAppPadding.current.rounded_app_padding.dp,
                    end = LocalAppPadding.current.rounded_app_padding.dp
                ),
                mainNavHostController = mainNavHostController
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize().background(LocalAppColor.current.backgroundColorDarkBody), verticalArrangement = Arrangement.Center
        ) {
            Box(modifier = Modifier, contentAlignment = Alignment.Center){
                TicketComponent()
                AsyncImage(model = "https://png.pngtree.com/png-vector/20230208/ourmid/pngtree-paid-stamp-vector-illustration-png-image_6585127.png", contentDescription = "", modifier = Modifier.fillMaxWidth().alpha(.5f))
            }
            Spacer(modifier = Modifier.padding(LocalAppPadding.current.rounded_app_padding.dp))
            ButtonBottomBar(
                "Come Back Home",
                modifier = Modifier.padding(
                    start = LocalAppPadding.current.rounded_app_padding.dp,
                    end = LocalAppPadding.current.rounded_app_padding.dp
                ),
                mainNavHostController = mainNavHostController,
                destinationNavigation = Screens.FilmFragment.route
            )
            Spacer(modifier = Modifier.padding(bottom = LocalAppPadding.current.top_app_padding.dp))
        }
    }
}

//@Preview
//@Composable
//fun PreviewPaymentSuccess() {
//    PaymentSuccessScreen()
//}