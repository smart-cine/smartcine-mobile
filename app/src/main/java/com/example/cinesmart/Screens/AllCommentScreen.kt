package com.example.cinesmart.Screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.cinesmart.Components.CommentComponent
import com.example.cinesmart.Components.CommentInPostComponent
import com.example.cinesmart.Components.RankingBoardComponent
import com.example.cinesmart.Components.StarAverage
import com.example.cinesmart.Components.TopBarTitleAndReturnButton
import com.example.cinesmart.Components.hideSystemNavBars
import com.example.cinesmart.Navigation.CineSmartNavController
import com.example.cinesmart.ui.theme.LocalAppColor
import com.example.cinesmart.ui.theme.LocalAppPadding
import com.example.cinesmart.ui.theme.LocalAppTypography


@Composable
fun AllCommentsScreen(modifier: Modifier = Modifier, mainNavHostController:CineSmartNavController) {
    val filmName: String = "Bat Man"
    val totalRanking: Int = 5500
    //TODO: Render All Server's Comment in separate page
    val listComment = listOf(1,2,3,4,5,6,7)

    hideSystemNavBars()
    Scaffold(
        topBar = {
            Column() {

                TopBarTitleAndReturnButton(
                    title = "All Comments", modifier = Modifier
                        .background(
                            LocalAppColor.current.backgroundColorDarkHeader
                        )
                        .padding(
                            start = LocalAppPadding.current.rounded_app_padding.dp,
                            end = LocalAppPadding.current.rounded_app_padding.dp,
                            top = LocalAppPadding.current.top_app_padding.dp,
                            bottom = LocalAppPadding.current.rounded_app_padding.dp
                        ),
                    mainNavHostController = mainNavHostController
                )
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(LocalAppColor.current.textBonusColorLight)
                        .padding(
                            top = (LocalAppPadding.current.rounded_app_padding / 2).dp,
                            bottom = (LocalAppPadding.current.rounded_app_padding / 2).dp,
                            start = (LocalAppPadding.current.rounded_app_padding / 2).dp,
                            end = (LocalAppPadding.current.rounded_app_padding / 2).dp,
                        ), horizontalArrangement = Arrangement.Start
                ) {
                    Text(
                        text = "Evaluate of ",
                        style = LocalAppTypography.current.text_14_normal,
                        color = LocalAppColor.current.textColorLight
                    )
                    Text(
                        text = filmName,
                        style = LocalAppTypography.current.text_14_bold,
                        color = LocalAppColor.current.textColorOrange
                    )
                }
            }
        }
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .padding(innerPadding)
                .background(LocalAppColor.current.backgroundColorDarkBody)
        ) {
            item {
                Row(
                    verticalAlignment = Alignment.CenterVertically, modifier = Modifier
                        .background(
                            LocalAppColor.current.backgroundColorDarkHeader
                        )
                        .padding(LocalAppPadding.current.rounded_app_padding.dp)
                ) {
                    Column {

                        StarAverage(point = 9.5f, type = "large")
                        Text(
                            text = "(${if (totalRanking >= 1000) (totalRanking / 1000f).toString() + "k" else totalRanking.toString()} evaluators)",
                            style = LocalAppTypography.current.text_12_bold,
                            color = LocalAppColor.current.textBonusColorLight
                        )
                    }
                    Spacer(modifier = Modifier.padding(LocalAppPadding.current.rounded_app_padding.dp))
                    RankingBoardComponent()
                }
            }
            item {
                Text(
                    text = "Write Preview",
                    color = LocalAppColor.current.textColorOrange,
                    style = LocalAppTypography.current.text_14_bold,
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable { }
                        .padding(
                            LocalAppPadding.current.rounded_app_padding.dp
                        ),
                    textAlign = TextAlign.Center
                )
            }
            itemsIndexed(listComment){index, item ->
                CommentComponent(comment = item, showReply = true, mainNavHostController = mainNavHostController)
            }
        }

    }
}

//@Preview
//@Composable
//fun PreviewScreen() {
//    AllCommentsScreen()
//}