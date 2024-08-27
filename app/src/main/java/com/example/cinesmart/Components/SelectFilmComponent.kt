package com.example.cinesmart.Components

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.KeyboardArrowRight
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.unit.dp
import androidx.compose.ui.util.lerp
import com.example.cinesmart.Navigation.CineSmartNavController
import com.example.cinesmart.Screens.Screens
import com.example.cinesmart.ui.theme.LocalAppColor
import com.example.cinesmart.ui.theme.LocalAppPadding
import com.example.cinesmart.ui.theme.LocalAppTypography
import com.google.accompanist.pager.ExperimentalPagerApi
import kotlin.math.absoluteValue

@Composable
fun TrendingComponent(mainNavHostController: CineSmartNavController) {
    Column(
        modifier = Modifier.padding(
            top = LocalAppPadding.current.rounded_app_padding.dp,
            bottom = LocalAppPadding.current.rounded_app_padding.dp
        )
    ) {
        TitleOfListFilmComponent("Trending Now")
        Spacer(modifier = Modifier.padding(top = LocalAppPadding.current.rounded_app_padding.dp))
        CarouselCard(mainNavHostController = mainNavHostController)
    }
}

@Composable
fun TitleOfListFilmComponent(title: String, view: Boolean = false) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxWidth(),
    ) {
        Text(
            text = title,
            style = LocalAppTypography.current.text_24_bold,
            color = LocalAppColor.current.textColorLight
        )
        if (view) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                    text = "View All",
                    style = LocalAppTypography.current.text_18_bold,
                    color = LocalAppColor.current.textColorLight
                )
                Icon(
                    imageVector = Icons.Rounded.KeyboardArrowRight,
                    contentDescription = "",
                    tint = LocalAppColor.current.textColorLight
                )
            }
        }
    }
}

@OptIn(ExperimentalPagerApi::class, ExperimentalFoundationApi::class)
@Composable
fun CarouselCard(mainNavHostController: CineSmartNavController) {
    //mock data
    val sliderList = listOf(
        "https://lumiere-a.akamaihd.net/v1/images/p_junglecruise_21740_v2_bb7f0ae4.jpeg",
        "https://rachelsreviews.net/wp-content/uploads/2016/06/film.jpg",
        "https://lumiere-a.akamaihd.net/v1/images/p_junglecruise_21740_v2_bb7f0ae4.jpeg",
        "https://lumiere-a.akamaihd.net/v1/images/p_junglecruise_21740_v2_bb7f0ae4.jpeg",
        "https://lumiere-a.akamaihd.net/v1/images/p_junglecruise_21740_v2_bb7f0ae4.jpeg",
        "https://lumiere-a.akamaihd.net/v1/images/p_junglecruise_21740_v2_bb7f0ae4.jpeg",
        "https://lumiere-a.akamaihd.net/v1/images/p_junglecruise_21740_v2_bb7f0ae4.jpeg",
        "https://lumiere-a.akamaihd.net/v1/images/p_junglecruise_21740_v2_bb7f0ae4.jpeg",
    )
    val ranking = 8.6f
    val numRating = 2200
    val title = "Kẻ trộm mặt trăng"
    val tag = "Hài, Hoạt Hình, Phiêu Lưu, Gia Đình"
    val restrict_age = 16

    //-----
    val pagerState = com.google.accompanist.pager.rememberPagerState(initialPage = 2)

    com.google.accompanist.pager.HorizontalPager(
        count = sliderList.size,
        state = pagerState,
        contentPadding = PaddingValues(horizontal = 100.dp),
        modifier = Modifier.wrapContentSize()
    ) { page ->
        Card(
            modifier = Modifier.graphicsLayer {
                val pageOffset = (
                        (pagerState.currentPage - page) + pagerState.currentPageOffset
                        ).absoluteValue
                lerp(
                    start = 0.85f,
                    stop = 1f,
                    fraction = 1f - pageOffset.coerceIn(0f, 1f)
                )
                    .also { scale ->
                        scaleX = scale
                        scaleY = scale
                    }
                alpha = lerp(
                    start = 0.5f,
                    stop = 1f,
                    fraction = 1f - pageOffset.coerceIn(0f, 1f)
                )
            }.clickable {
                mainNavHostController.navController.navigate(Screens.FilmInfoScreen.route)
            },
            colors = CardColors(
                Color.Transparent,
                Color.Transparent,
                Color.Transparent,
                Color.Transparent
            )
        ) {
            Column {

                ImageWithTags(300, 8.6f)
                Spacer(modifier = Modifier.padding(4.dp))
                InfoFilm(isCenter = true)
            }
        }
    }
}

@OptIn(ExperimentalPagerApi::class)
@Composable
fun NewReleasesComponent(mainNavHostController: CineSmartNavController) {
    val listFilm = listOf(
        "https://lumiere-a.akamaihd.net/v1/images/p_junglecruise_21740_v2_bb7f0ae4.jpeg",
        "https://rachelsreviews.net/wp-content/uploads/2016/06/film.jpg",
        "https://lumiere-a.akamaihd.net/v1/images/p_junglecruise_21740_v2_bb7f0ae4.jpeg",
        "https://lumiere-a.akamaihd.net/v1/images/p_junglecruise_21740_v2_bb7f0ae4.jpeg",
        "https://lumiere-a.akamaihd.net/v1/images/p_junglecruise_21740_v2_bb7f0ae4.jpeg",
        "https://lumiere-a.akamaihd.net/v1/images/p_junglecruise_21740_v2_bb7f0ae4.jpeg",
        "https://lumiere-a.akamaihd.net/v1/images/p_junglecruise_21740_v2_bb7f0ae4.jpeg",
        "https://lumiere-a.akamaihd.net/v1/images/p_junglecruise_21740_v2_bb7f0ae4.jpeg",
    )
    Column(modifier = Modifier.padding(top = LocalAppPadding.current.rounded_app_padding.dp)) {
        TitleOfListFilmComponent("New Releases", true)
        LazyRow(
            modifier = Modifier.padding(
                top = LocalAppPadding.current.rounded_app_padding.dp
            )
        ) {
            itemsIndexed(listFilm) { index, item ->
                Column(
                    modifier = Modifier
                        .width(200.dp)
                        .wrapContentHeight()
                        .padding(end = if (index != (listFilm.size - 1)) 12.dp else 0.dp)
                        .clickable {
                            mainNavHostController.navController.navigate(Screens.FilmInfoScreen.route)
                        }
                ) {
                    ImageWithTags(260, 8.6f)
                    Spacer(modifier = Modifier.padding(4.dp))
                    InfoFilm(isCenter = false, isMaxlineText = true, isComming = false)
                }
            }
        }
    }
}

@Composable
fun UpcommingComponent(mainNavHostController: CineSmartNavController) {
    val listFilm = listOf(
        "https://lumiere-a.akamaihd.net/v1/images/p_junglecruise_21740_v2_bb7f0ae4.jpeg",
        "https://lumiere-a.akamaihd.net/v1/images/p_junglecruise_21740_v2_bb7f0ae4.jpeg",
        "https://lumiere-a.akamaihd.net/v1/images/p_junglecruise_21740_v2_bb7f0ae4.jpeg",
        "https://lumiere-a.akamaihd.net/v1/images/p_junglecruise_21740_v2_bb7f0ae4.jpeg",
        "https://lumiere-a.akamaihd.net/v1/images/p_junglecruise_21740_v2_bb7f0ae4.jpeg",
        "https://lumiere-a.akamaihd.net/v1/images/p_junglecruise_21740_v2_bb7f0ae4.jpeg",
        "https://lumiere-a.akamaihd.net/v1/images/p_junglecruise_21740_v2_bb7f0ae4.jpeg",
        "https://lumiere-a.akamaihd.net/v1/images/p_junglecruise_21740_v2_bb7f0ae4.jpeg",
    )
    Column(modifier = Modifier.padding(top = LocalAppPadding.current.rounded_app_padding.dp)) {
        TitleOfListFilmComponent(title = "Comming Soon", view = true)
        LazyRow(modifier = Modifier.padding(top = LocalAppPadding.current.rounded_app_padding.dp)) {
            itemsIndexed(listFilm) { index, item ->
                Column(
                    modifier = Modifier
                        .width(150.dp)
                        .padding(end = if (index != listFilm.size - 1) 12.dp else 0.dp)
                        .clickable {
                            mainNavHostController.navController.navigate(Screens.FilmInfoScreen.route)
                        }
                ) {
                    ImageWithTags(height = 200)
                    Spacer(modifier = Modifier.padding(4.dp))
                    InfoFilm(isCenter = false, isMaxlineText = true, isComming = true)
                }
            }
        }
    }
}
