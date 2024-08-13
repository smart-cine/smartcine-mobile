package com.example.cinesmart.Screens

import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.cinesmart.Components.Background
import com.example.cinesmart.Components.ButtonBottomBar
import com.example.cinesmart.Components.FilmInfoBlock
import com.example.cinesmart.Components.NavigationBarFilmInfo
import com.example.cinesmart.Components.TopBarTitleAndReturnButton
import com.example.cinesmart.ui.theme.LocalAppColor
import com.example.cinesmart.ui.theme.LocalAppPadding
import dev.chrisbanes.haze.HazeState
import dev.chrisbanes.haze.hazeChild

@Composable
fun InfoFilmHeader(
    modifier: Modifier = Modifier,
    navigateState: String,
    changeNavigateState: () -> Unit
) {
    Column(modifier = modifier) {
        TopBarTitleAndReturnButton(
            "Thám Tử Lừng Danh Conan: Ngôi Sao 5 Cánh 1 Triệu Đô", modifier = Modifier.padding(
                start = LocalAppPadding.current.rounded_app_padding.dp,
                end = LocalAppPadding.current.rounded_app_padding.dp,
                top = LocalAppPadding.current.top_app_padding.dp,
                bottom = LocalAppPadding.current.rounded_app_padding.dp
            )
        )
        NavigationBarFilmInfo(
            navigateState = navigateState,
            changeNavigateState = changeNavigateState
        )
    }
}

@Composable
fun FilmInfoScreen() {
    val nameFilm = "Thám Tử Lừng Danh Conan: Ngôi Sao 5 Cánh 1 Triệu Đô"
    val navigateState = rememberSaveable {
        mutableStateOf("Sessions")

    }
    var changeNavigateState: () -> Unit = {
        print(navigateState.value)
        if (navigateState.value == "About") navigateState.value =
            "Sessions" else navigateState.value = "About"
    }
    Background()
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(LocalAppColor.current.backgroundColorDarkBody.copy(alpha = .8f))
    ) {
        val hazeState = remember { HazeState() }
        Scaffold(
            topBar = {
                InfoFilmHeader(
                    modifier = Modifier
                        .background(LocalAppColor.current.backgroundColorDarkHeader)
                        .hazeChild(state = hazeState),
                    navigateState = navigateState.value,
                    changeNavigateState = changeNavigateState,
                )
            },
            bottomBar = {
                Box(
                    modifier = Modifier
                        .background(LocalAppColor.current.backgroundColorDarkHeader)
                        .padding(
                            top = LocalAppPadding.current.rounded_app_padding.dp,
                            start = LocalAppPadding.current.rounded_app_padding.dp,
                            end = LocalAppPadding.current.rounded_app_padding.dp,
                            bottom = (5 * LocalAppPadding.current.rounded_app_padding).dp
                        )
                ) {

                    ButtonBottomBar()
                }
            },
            contentColor = Color.Transparent,
            containerColor = Color.Transparent,
        ) { innerPadding ->
                FilmInfoBlock(
                    modifier = Modifier.padding(innerPadding),
                    navigateState = navigateState.value
                )
            }

    }
}

@Preview(showBackground = true)
@Composable
fun PreviewComposable() {
    FilmInfoScreen()
}