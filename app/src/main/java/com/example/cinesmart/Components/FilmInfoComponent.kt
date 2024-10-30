package com.example.cinesmart.Components

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.KeyboardArrowDown
import androidx.compose.material.icons.rounded.KeyboardArrowUp
import androidx.compose.material.icons.rounded.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.cinesmart.Navigation.CineSmartNavController
import com.example.cinesmart.Screens.Screens
import com.example.cinesmart.ui.theme.LocalAppColor
import com.example.cinesmart.ui.theme.LocalAppPadding
import com.example.cinesmart.ui.theme.LocalAppTypography
import com.example.cinesmart.ui.theme.shadow
import java.sql.Timestamp

@Composable
fun NavigationBarFilmInfo(
    navigateState: String,
    modifier: Modifier = Modifier,
    changeNavigateState: () -> Unit
) {
    val colorHover = LocalAppColor.current.buttonColorDarkBottom
    val animateHoverAbout by animateFloatAsState(if (navigateState == "About") 10f else 0f)
    val animateHoverSessions by animateFloatAsState(if (navigateState == "Sessions") 10f else 0f)

    Row() {
        Box(modifier = Modifier
            .clickable { changeNavigateState() }
            .weight(1f)

            .drawBehind {
                drawLine(
                    color = colorHover,
                    start = Offset(0f, size.height),
                    end = Offset(size.width, size.height),
                    strokeWidth = animateHoverAbout
                )
            }
            .padding(top = 12.dp, bottom = 12.dp), contentAlignment = Alignment.Center
        ) {
            TextWithShadow(name = "About", navigateState = navigateState)
        }
        Box(modifier = Modifier
            .clickable { changeNavigateState() }
            .weight(1f)
            .drawBehind {
                drawLine(
                    color = colorHover,
                    start = Offset(0f, size.height),
                    end = Offset(size.width, size.height),
                    strokeWidth = animateHoverSessions
                )
            }
            .padding(top = 12.dp, bottom = 12.dp), contentAlignment = Alignment.Center) {
            TextWithShadow(name = "Sessions", navigateState = navigateState)
        }
    }
}

@Composable
fun TextWithShadow(modifier: Modifier = Modifier, name: String, navigateState: String) {
    val animateColor by animateColorAsState(if (navigateState == name) LocalAppColor.current.textColorOrange else LocalAppColor.current.textBonusColorLight)

    Text(
        text = name,
        style = if (navigateState == name) LocalAppTypography.current.text_16_bold.copy(
            color = LocalAppColor.current.textColorOrange,
            shadow = Shadow(
                color = LocalAppColor.current.textColorOrange,
                offset = Offset(1f, 1f),
                blurRadius = 30f
            )
        ) else LocalAppTypography.current.text_16_bold.copy(
            color = LocalAppColor.current.textBonusColorLight
        )
    )
}

@Composable
fun FilmInfoBlock(modifier: Modifier = Modifier, navigateState: String, mainNavHostController:CineSmartNavController) {
    // TODO 1: Create enum class hold About and Sessions
    if (navigateState == "About") {
        FilmDescriptionBlock(modifier = modifier, mainNavHostController = mainNavHostController)
    } else {
        FilmPerformBlock(modifier = modifier, mainNavHostController = mainNavHostController)
    }
}

@Composable
fun FilmDescriptionBlock(modifier: Modifier = Modifier, mainNavHostController: CineSmartNavController) {
    //TODO: Mock data info film
    //TODO: inject viewmodel to get all field here
    val trailerId: String by remember {
        mutableStateOf("mqqft2x_Aa4")

    }
    val pictureUrl: String =
        "https://m.media-amazon.com/images/M/MV5BOGE2NWUwMDItMjA4Yi00N2Y3LWJjMzEtMDJjZTMzZTdlZGE5XkEyXkFqcGdeQXVyODk4OTc3MTY@._V1_.jpg"
    val description: String =
        "When the Riddler, a sadistic serial killer, begins murdering key political figures in Gotham, Batman is forced to investigate the city's hidden corruption and question his family's involvement"
    val restrictAge = 16
    val filmTag = "Cartoon, Action, Drama"
    val releaseDate: Timestamp = Timestamp(2024, 8, 2, 0, 0, 0, 0)
    val duration: Int = 123
    val language: String = "Vietnamese"
    val director: String = "Matt Reeves"
    val cast: String = "Robert Pattinson, Jeffrey Wright, Colin Farrell"
    val averageRating: Float = 9.5f
    val listComment = listOf(1, 2, 3)

    Column(modifier = modifier.verticalScroll(rememberScrollState())) {
        YoutubePlayerComponent(videoId = trailerId)
        DurationTimeAndLanguageRowComponent(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .background(LocalAppColor.current.backgroundColorDarkHeader),
            releaseDate = releaseDate,
            duration = duration,
            averageRating = averageRating
        )
        ImageFilmAndInfoComponent(
            modifier = Modifier
                .background(LocalAppColor.current.backgroundColorDarkBody)
                .padding(LocalAppPadding.current.rounded_app_padding.dp),
            pictureUrl = pictureUrl,
            description = description,
            filmTag = filmTag,
            restrictAge = restrictAge,
            releaseDate = releaseDate,
            duration = duration,
            director = director,
            cast = cast,
            language = language
        )
        RankingBoardComponent(
            modifier = Modifier
                .background(LocalAppColor.current.backgroundColorDarkHeader)
                .padding(LocalAppPadding.current.rounded_app_padding.dp)
        )
        //TODO: filter 3 elements of listComment to show, all comments will be shown at detail comment screen.
        Column(
            modifier = Modifier
                .background(LocalAppColor.current.backgroundColorDarkBody)
                .padding(
                    top = LocalAppPadding.current.rounded_app_padding.dp,
                    start = LocalAppPadding.current.rounded_app_padding.dp,
                    end = LocalAppPadding.current.rounded_app_padding.dp,
                )
        ) {
            for (comment in listComment)
                CommentComponent(comment = comment, mainNavHostController =mainNavHostController)
        }
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .background(LocalAppColor.current.backgroundColorDarkBody)
                .clickable { }
                .padding(
                    top = (LocalAppPadding.current.rounded_app_padding / 2).dp,
                    start = LocalAppPadding.current.rounded_app_padding.dp,
                    end = LocalAppPadding.current.rounded_app_padding.dp,
                    bottom = LocalAppPadding.current.rounded_app_padding.dp,
                ),

            text = "Show All Comments",
            style = LocalAppTypography.current.text_14_bold,
            color = LocalAppColor.current.textColorOrange,
            textAlign = TextAlign.Center

        )
    }
}


@Composable
fun CommentComponent(comment: Int/* TODO: FIX*/, showReply: Boolean = false, mainNavHostController: CineSmartNavController) {
    val avatarUser: String? = null
//        "https://static.vecteezy.com/system/resources/thumbnails/029/796/026/small_2x/asian-girl-anime-avatar-ai-art-photo.jpg"
    val userName: String = "Alex Gi"
    val commentBody: String =
        "Phim nhu cut, xem phim mac ia bo me. Phim nhu cut, xem phim mac ia bo me. Phim nhu cut, xem phim mac ia bo me. Phim nhu cut, xem phim mac ia bo me. Phim nhu cut, xem phim mac ia bo me. Phim nhu cut, xem phim mac ia bo me. Phim nhu cut, xem phim mac ia bo me. Phim nhu cut, xem phim mac ia bo me. Phim nhu cut, xem phim mac ia bo me. Phim nhu cut, xem phim mac ia bo me. Phim nhu cut, xem phim mac ia bo me. Phim nhu cut, xem phim mac ia bo me. Phim nhu cut, xem phim mac ia bo me"
    val userPoint: Float = 9.5f
    var isExtended by rememberSaveable {
        mutableStateOf(false)
    }
    var isLiked by rememberSaveable {
        mutableStateOf(false)
    }
    var totalLike by rememberSaveable {
        mutableStateOf(12)
    }
    Column(
        modifier = Modifier
            .padding(
                bottom = (LocalAppPadding.current.rounded_app_padding / 3).dp
            )
            .clickable { mainNavHostController.navController.navigate(Screens.AllCommentScreen.route)}
    ) {
        Column(
            modifier = Modifier

                .clip(RoundedCornerShape(4.dp))
                .border(
                    1.dp,
                    LocalAppColor.current.backgroundColorDarkHeader,
                    RoundedCornerShape(4.dp)
                )
                .padding(LocalAppPadding.current.rounded_app_padding.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(bottom = (LocalAppPadding.current.rounded_app_padding / 2).dp)
            ) {
                if (avatarUser != null) {
                    AsyncImage(
                        model = avatarUser,
                        contentDescription = "",
                        modifier = Modifier
                            .size(38.dp)
                            .clip(
                                CircleShape
                            )
                    )
                } else {
                    AvatarUserWithFirstLetter()
                }
                Column(
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier.padding(start = LocalAppPadding.current.rounded_app_padding.dp)
                ) {
                    Text(
                        text = userName,
                        style = LocalAppTypography.current.text_16_bold,
                        color = LocalAppColor.current.textColorLight
                    )
                    Text(
                        text = "Purchased via Cinesmart",
                        style = LocalAppTypography.current.text_12_bold,
                        color = LocalAppColor.current.textColorOrange
                    )
                }
            }
            StarAverage(userPoint, "small")
            Text(
                text = commentBody,
                style = LocalAppTypography.current.text_16_normal,
                color = LocalAppColor.current.textBonusColorLight,
                maxLines = if (isExtended
                ) Int.MAX_VALUE else 3,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier
                    .clickable {
                        isExtended = !isExtended
                    }
                    .animateContentSize()

            )
            if (!isExtended) {
                Text(
                    text = "Show more",
                    style = LocalAppTypography.current.text_12_bold,
                    color = LocalAppColor.current.textColorLight,
                    modifier = Modifier.clickable {
                        println(isExtended)
                        isExtended = !isExtended
                    }
                )
            }
            Row(modifier = Modifier.padding(top = (2 * LocalAppPadding.current.rounded_app_padding).dp)) {
                LikeCommentButton("like", totalLike, modifier = Modifier
                    .clickable { /*TODO:Like comment Button*/ }
                    .clip(
                        RoundedCornerShape(4.dp)
                    )
                    .border(
                        1.dp,
                        LocalAppColor.current.backgroundColorDarkHeader,
                        RoundedCornerShape(4.dp)
                    )

                    .weight(1f),
                    onclick = {
                        isLiked = !isLiked
                        if (isLiked) {
                            totalLike++
                        } else totalLike--
                    },
                    isLiked = isLiked
                )
                Spacer(modifier = Modifier.padding(start = (LocalAppPadding.current.rounded_app_padding / 2).dp))
                LikeCommentButton(
                    type = "comment", total = 3, modifier = Modifier
                        .clip(
                            RoundedCornerShape(4.dp)
                        )
                        .border(
                            1.dp,
                            LocalAppColor.current.backgroundColorDarkHeader,
                            RoundedCornerShape(4.dp)
                        )

                        .weight(1f),
                    onclick = {
                    },
                    isLiked = isLiked
                )
                Spacer(modifier = Modifier.padding(start = (LocalAppPadding.current.rounded_app_padding / 2).dp))
                LikeCommentButton(
                    type = "share", total = 3, modifier = Modifier
                        .clip(
                            RoundedCornerShape(4.dp)
                        )
                        .border(
                            1.dp,
                            LocalAppColor.current.backgroundColorDarkHeader,
                            RoundedCornerShape(4.dp)
                        )
                        .weight(1f),
                    onclick = {
                    },
                    isLiked = isLiked
                )
            }
            if (showReply) {
                Column(
                    modifier = Modifier.padding(
                        top = LocalAppPadding.current.rounded_app_padding.dp,
                        start = LocalAppPadding.current.rounded_app_padding.dp,
                        end = LocalAppPadding.current.rounded_app_padding.dp,
                    )
                ) {
                    CommentInPostComponent()
                    CommentInPostComponent()
                    CommentInPostComponent()
                }
            }
        }
    }

}


@Composable
fun RankingBoardComponent(modifier: Modifier = Modifier) {
    Row(modifier = modifier, verticalAlignment = Alignment.CenterVertically) {
        DetailBoardRatingComponent()
    }
}


@Composable
fun DetailBoardRatingComponent() {
    val star9_10 = 4000
    val star7_8 = 500
    val star5_6 = 200
    val star3_4 = 100
    val star1_2 = 700
    val totalRating = 5500
    Column {
        FieldRating(typeRating = "9-10", totalRating = totalRating, count = star9_10)
        FieldRating(typeRating = "7-8", totalRating = totalRating, count = star7_8)
        FieldRating(typeRating = "5-6", totalRating = totalRating, count = star5_6)
        FieldRating(typeRating = "3-4", totalRating = totalRating, count = star3_4)
        FieldRating(typeRating = "1-2", totalRating = totalRating, count = star1_2)
    }
}

@Composable
fun FieldRating(typeRating: String, totalRating: Int, count: Int) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Row(
            modifier = Modifier.weight(1f),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Text(
                text = typeRating,
                textAlign = TextAlign.Center,
                color = LocalAppColor.current.textColorLight,
                style = LocalAppTypography.current.text_14_normal
            )
            Icon(
                imageVector = Icons.Rounded.Star,
                contentDescription = null,
                tint = LocalAppColor.current.textBonusColorLight
            )
        }
        Box(
            modifier = Modifier
                .height(4.dp)
                .weight(5f)
                .background(LocalAppColor.current.textBonusColorLight)
        ) {
            Box(
                modifier = Modifier
                    .height(4.dp)
                    .fillMaxWidth(count.toFloat() / totalRating)
                    .background(LocalAppColor.current.buttonColorDarkCenter)
                    .shadow(
                        RectangleShape,
                        LocalAppColor.current.buttonColorDarkCenter,
                        5.dp,
                        0.dp,
                        0.dp,
                        0.dp
                    )
            )
        }
    }
}

@Composable
fun ImageFilmAndInfoComponent(
    modifier: Modifier = Modifier,
    pictureUrl: String,
    description: String,
    filmTag: String,
    restrictAge: Int,
    releaseDate: Timestamp,
    duration: Int,
    director: String,
    cast: String,
    language: String
) {
    Column(modifier = modifier) {
        Row(verticalAlignment = Alignment.Top) {
            Text(
                text = "Description",
                modifier = Modifier.weight(1f),
                color = LocalAppColor.current.textBonusColorLight,
                style = LocalAppTypography.current.text_14_normal
            )
            Text(
                text = description,
                modifier = Modifier.weight(3f),
                color = LocalAppColor.current.textColorLight,
                style = LocalAppTypography.current.text_14_normal
            )
        }
        Spacer(modifier = Modifier.height(10.dp))
        Row(verticalAlignment = Alignment.Top) {
            Text(
                text = "Restrict Age",
                modifier = Modifier.weight(1f),
                color = LocalAppColor.current.textBonusColorLight,
                style = LocalAppTypography.current.text_14_normal
            )
            Box(
                modifier = Modifier
                    .weight(3f)
                    .wrapContentHeight()
            ) {
                TagRankAndAge(restrict_age = restrictAge)
            }
        }
        Spacer(modifier = Modifier.height(10.dp))

        Row(verticalAlignment = Alignment.Top) {
            Text(
                text = "Genre",
                modifier = Modifier.weight(1f),
                color = LocalAppColor.current.textBonusColorLight,
                style = LocalAppTypography.current.text_14_normal
            )
            Text(
                text = filmTag,
                modifier = Modifier.weight(3f),
                color = LocalAppColor.current.textColorLight,
                style = LocalAppTypography.current.text_14_normal
            )
        }
        Spacer(modifier = Modifier.height(10.dp))
        Row(verticalAlignment = Alignment.Top) {
            Text(
                text = "Director",
                modifier = Modifier.weight(1f),
                color = LocalAppColor.current.textBonusColorLight,
                style = LocalAppTypography.current.text_14_normal
            )
            Text(
                text = director,
                modifier = Modifier.weight(3f),
                color = LocalAppColor.current.textColorLight,
                style = LocalAppTypography.current.text_14_normal
            )
        }
        Spacer(modifier = Modifier.height(10.dp))
        Row(verticalAlignment = Alignment.Top) {
            Text(
                text = "Language",
                modifier = Modifier.weight(1f),
                color = LocalAppColor.current.textBonusColorLight,
                style = LocalAppTypography.current.text_14_normal
            )
            Text(
                text = language,
                modifier = Modifier.weight(3f),
                color = LocalAppColor.current.textColorLight,
                style = LocalAppTypography.current.text_14_normal
            )
        }
        Spacer(modifier = Modifier.height(10.dp))
        Row(verticalAlignment = Alignment.Top) {
            Text(
                text = "Cast",
                modifier = Modifier.weight(1f),
                color = LocalAppColor.current.textBonusColorLight,
                style = LocalAppTypography.current.text_14_normal
            )
            Text(
                text = cast,
                modifier = Modifier.weight(3f),
                color = LocalAppColor.current.textColorLight,
                style = LocalAppTypography.current.text_14_normal
            )
        }
    }
}

@Composable
fun DurationTimeAndLanguageRowComponent(
    modifier: Modifier = Modifier,
    releaseDate: Timestamp,
    duration: Int,
    averageRating: Float
) {

    Row(modifier = modifier, verticalAlignment = Alignment.CenterVertically) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .weight(1f)
                .padding(
                    top = LocalAppPadding.current.rounded_app_padding.dp,
                    bottom = LocalAppPadding.current.rounded_app_padding.dp,
                )
        ) {
            Text(
                text = "${releaseDate.year}",
                color = LocalAppColor.current.textColorLight,
                style = LocalAppTypography.current.text_16_bold
            )
            Text(
                text = "Release",
                color = LocalAppColor.current.textBonusColorLight,
                style = LocalAppTypography.current.text_14_normal
            )
        }
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .weight(1f)
                .padding(
                    top = LocalAppPadding.current.rounded_app_padding.dp,
                    bottom = LocalAppPadding.current.rounded_app_padding.dp,

                    )
        ) {
            Text(
                text = averageRating.toString(),
                color = LocalAppColor.current.textColorLight,
                style = LocalAppTypography.current.text_16_bold
            )
            Text(
                text = "Rating",
                color = LocalAppColor.current.textBonusColorLight,
                style = LocalAppTypography.current.text_14_normal
            )
        }
        //TODO: Make separate line fill full height of Box
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .weight(1f)
                .padding(
                    top = LocalAppPadding.current.rounded_app_padding.dp,
                    bottom = LocalAppPadding.current.rounded_app_padding.dp,

                    )
        ) {
            Text(
                text = "${duration}",
                color = LocalAppColor.current.textColorLight,
                style = LocalAppTypography.current.text_16_bold
            )
            Text(
                text = "Duration",
                color = LocalAppColor.current.textBonusColorLight,
                style = LocalAppTypography.current.text_14_normal
            )
        }


    }
}


@Composable
fun FilmPerformBlock(modifier: Modifier = Modifier, mainNavHostController: CineSmartNavController) {
    val listCinema = listOf(1, 2, 3, 4, 5, 6, 7)
    val listPerformCinema = listOf(1, 2, 3, 4, 5, 6, 7, 8)
    Scaffold(
        modifier = modifier,
        topBar = {
            DayFilterRowComponent(
                modifier = Modifier.padding(
                    top = LocalAppPadding.current.rounded_app_padding.dp,
                    bottom = LocalAppPadding.current.rounded_app_padding.dp
                )
            )
        }
    ) { innerpadding ->

        LazyColumn(
            modifier = Modifier
                .background(LocalAppColor.current.backgroundColorDarkBody)
                .padding(innerpadding)
        ) {
            item {
                Box(modifier = Modifier.padding(LocalAppPadding.current.rounded_app_padding.dp)) {
                    LazyRow(
                        modifier = Modifier
                            .clip(RoundedCornerShape(6.dp))
                            .background(
                                LocalAppColor.current.backgroundColorDarkHeader
                            )

                            .padding(
                                top = LocalAppPadding.current.rounded_app_padding.dp,
                                bottom = LocalAppPadding.current.rounded_app_padding.dp,
                                start = (LocalAppPadding.current.rounded_app_padding / 2).dp,
                                end = (LocalAppPadding.current.rounded_app_padding / 2).dp
                            )

                    ) {
                        itemsIndexed(listCinema) { index, item ->
                            CinemaLogoComponent(false)
                            CinemaLogoComponent(true)
                        }
                    }
                }
            }
            itemsIndexed(listPerformCinema) { index, item ->
                PerformCinema(index = index, mainNavHostController = mainNavHostController)
            }
        }

    }

}

@Composable
fun PerformCinema(index: Int, modifier: Modifier = Modifier, mainNavHostController: CineSmartNavController) {
    val cinemaName = "BHD Star Le Van Viet"
    val isExpanded = remember {
        mutableStateOf(false)
    }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                start = LocalAppPadding.current.rounded_app_padding.dp,
                end = LocalAppPadding.current.rounded_app_padding.dp
            )
            .clip(
                if (index == 0) RoundedCornerShape(
                    topStart = 12.dp,
                    topEnd = 12.dp
                ) else RoundedCornerShape(0.dp)
            )
            .background(LocalAppColor.current.backgroundColorDarkHeader)
            .animateContentSize()
            .clickable { isExpanded.value = !isExpanded.value }

    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    LocalAppPadding.current.rounded_app_padding.dp
                ),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {

                AsyncImage(
                    model = "https://cdn.nhanlucnganhluat.vn/uploads/images/D69545BE/logo/2019-04/pictures_library_6235_20180102135750_4563.jpg",
                    contentDescription = "",
                    modifier = Modifier
                        .size(50.dp)
                        .clip(RoundedCornerShape(8.dp))
                )
                Spacer(modifier = Modifier.padding(start = LocalAppPadding.current.rounded_app_padding.dp))
                Text(
                    text = cinemaName,
                    color = LocalAppColor.current.textColorLight,
                    style = LocalAppTypography.current.text_16_bold
                )
            }
            Icon(
                imageVector = if (!isExpanded.value) Icons.Rounded.KeyboardArrowDown else Icons.Rounded.KeyboardArrowUp,
                contentDescription = "",
                tint = LocalAppColor.current.textColorLight,
                modifier = Modifier.clickable { isExpanded.value = !isExpanded.value }
            )
        }
        if (isExpanded.value) {
            GridPerform(mainNavHostController = mainNavHostController)
        }
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(LocalAppPadding.current.rounded_app_padding.dp)
                .height(1.dp)
                .background(LocalAppColor.current.textBonusColorLight)
        )

    }

}

@Composable
fun GridPerform(mainNavHostController: CineSmartNavController) {
    val listPerform by remember {
        mutableStateOf(listOf(1, 2, 3, 4, 5, 6, 7, 8))
    }
    LazyVerticalGrid(
        columns = GridCells.Fixed(3), modifier = Modifier
            .heightIn(0.dp, 10000.dp)
            .padding(
                (LocalAppPadding.current.rounded_app_padding / 2).dp
            )
    ) {
        itemsIndexed(listPerform) { index, item ->
            Box(
                modifier = Modifier
                    .padding(
                        top = LocalAppPadding.current.rounded_app_padding.dp,
                        bottom = LocalAppPadding.current.rounded_app_padding.dp,
                        start = (LocalAppPadding.current.rounded_app_padding / 2).dp,
                        end = (LocalAppPadding.current.rounded_app_padding / 2).dp,
                    )
                    .clip(RoundedCornerShape(8.dp))
                    .background(LocalAppColor.current.backgroundColorDarkBody)
                    .padding(LocalAppPadding.current.rounded_app_padding.dp)
                    .wrapContentHeight()
            ) {
                PerformItem(mainNavHostController = mainNavHostController)
            }
        }
    }
}

@Composable
fun PerformItem(modifier: Modifier = Modifier, mainNavHostController: CineSmartNavController) {
    val startTime = "09:00"
    val endTime = "11:03"
    Column(
        modifier = Modifier
            .fillMaxSize()
            .clickable {mainNavHostController.navController.navigate(Screens.PickSeatScreen.route) }, horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(modifier = Modifier, verticalAlignment = Alignment.Bottom) {
            Text(
                text = startTime,
                style = LocalAppTypography.current.text_18_bold,
                color = LocalAppColor.current.textColorLight
            )
            Text(
                text = " ~$endTime",
                style = LocalAppTypography.current.text_14_bold,
                color = LocalAppColor.current.textBonusColorLight
            )
        }
        Spacer(modifier = Modifier.padding((LocalAppPadding.current.rounded_app_padding / 2).dp))
        Text(
            text = "112/112 left",
            style = LocalAppTypography.current.text_14_bold,
            color = LocalAppColor.current.textBonusColorLight
        )
    }
}

//@Preview
//@Composable
//fun PreviewPerformCinema() {
//    PerformCinema(index = 0)
//}

@Composable
fun ListPerformComponent(modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        PerformComponent(isExpanded = false)
    }
}

@Composable
fun PerformComponent(modifier: Modifier = Modifier, isExpanded: Boolean) {
    Row() {

    }
}

@Preview
@Composable
fun PreviewPerformComponent() {
    PerformComponent(isExpanded = false)
}

@Composable
fun CinemaLogoComponent(focus: Boolean) {
    val nameCinema = "Lotte"
    Column(
        modifier = Modifier
            .padding((LocalAppPadding.current.rounded_app_padding).dp)
            .size(70.dp)
    ) {
        AsyncImage(
            model = "https://cdn.nhanlucnganhluat.vn/uploads/images/D69545BE/logo/2019-04/pictures_library_6235_20180102135750_4563.jpg",
            contentDescription = "",
            modifier = Modifier
                .fillMaxWidth()
                .border(
                    if (focus) 2.dp else 0.dp,
                    LocalAppColor.current.textColorOrange,
                    RoundedCornerShape(6.dp)
                )
                .shadow(
                    RoundedCornerShape(6.dp),
                    LocalAppColor.current.textColorOrange,
                    if (focus) 5.dp else 0.dp,
                    0.dp,
                    0.dp,
                    0.dp
                )
                .clip(
                    RoundedCornerShape(6.dp)
                )
        )
        Spacer(modifier = Modifier.padding(2.dp))
        Text(
            text = nameCinema,
            style = LocalAppTypography.current.text_16_bold,
            color = if (!focus) LocalAppColor.current.textBonusColorLight else LocalAppColor.current.textColorLight,
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center
        )
    }
}

@Composable
fun InfoFilmHeader(
    modifier: Modifier = Modifier,
    navigateState: String,
    changeNavigateState: () -> Unit,
    mainNavHostController:CineSmartNavController
) {
    Column(modifier = modifier) {
        TopBarTitleAndReturnButton(
            "Thám Tử Lừng Danh Conan: Ngôi Sao 5 Cánh 1 Triệu Đô", modifier = Modifier.padding(
                start = LocalAppPadding.current.rounded_app_padding.dp,
                end = LocalAppPadding.current.rounded_app_padding.dp,
                top = LocalAppPadding.current.top_app_padding.dp,
                bottom = LocalAppPadding.current.rounded_app_padding.dp
            ),
            mainNavHostController = mainNavHostController
        )
        NavigationBarFilmInfo(
            navigateState = navigateState,
            changeNavigateState = changeNavigateState
        )
    }
}

//@Preview(showBackground = true, widthDp = 600, heightDp = 500)
//@Composable
//fun PreviewComponent() {
//    FilmPerformBlock()
//}
