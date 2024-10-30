package com.example.cinesmart.Screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.cinesmart.Components.Background
import com.example.cinesmart.Components.MainHeader
import com.example.cinesmart.Components.NewReleasesComponent
import com.example.cinesmart.Components.TrendingComponent
import com.example.cinesmart.Components.UpcommingComponent
import com.example.cinesmart.Components.hideSystemNavBars
import com.example.cinesmart.Navigation.CineSmartNavController
import com.example.cinesmart.ui.theme.LocalAppColor
import com.example.cinesmart.ui.theme.LocalAppPadding
import dev.chrisbanes.haze.HazeState
import dev.chrisbanes.haze.haze
import dev.chrisbanes.haze.hazeChild


@Composable
fun SelectFilmScreen(mainNavHostController:CineSmartNavController, modifier: Modifier = Modifier) {
    hideSystemNavBars()
    Background()
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(LocalAppColor.current.backgroundColorDarkBody.copy(alpha = .8f))
    ) {
        val hazeState = remember { HazeState() }
        Scaffold(
            topBar = {
                MainHeader(
                    modifier = Modifier
                        .fillMaxWidth()
                        .hazeChild(
                            state = hazeState
                        ),
                    mainNavHostController = mainNavHostController
                )
            },
            bottomBar = {},
            contentColor = Color.Transparent,
            containerColor = Color.Transparent,
        ) { innerPadding ->
            LazyColumn(
                modifier = Modifier
                    .haze(
                        hazeState,
                        backgroundColor = Color.Transparent,
                        tint = Color.White.copy(alpha = .01f),
                        blurRadius = 50.dp,
                    )
                    .padding(
                        start = LocalAppPadding.current.rounded_app_padding.dp,
                        end = LocalAppPadding.current.rounded_app_padding.dp,
                    )
                    .padding(innerPadding)
            ) {
                item {
                    TrendingComponent(mainNavHostController = mainNavHostController)
                    NewReleasesComponent(mainNavHostController = mainNavHostController)
                    UpcommingComponent(mainNavHostController = mainNavHostController)
                }
            }
        }

    }
}


//@Preview(showBackground = true)
//@Composable
//fun PreviewSelectFilmScreen() {
//    SelectFilmScreen()
//}