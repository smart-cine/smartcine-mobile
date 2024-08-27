package com.example.cinesmart.Components

import android.app.Activity
import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.FastOutLinearInEasing
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.animation.with
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.rememberTransformableState
import androidx.compose.foundation.gestures.transformable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Share
import androidx.compose.material.icons.rounded.AccountCircle
import androidx.compose.material.icons.rounded.Close
import androidx.compose.material.icons.rounded.DateRange
import androidx.compose.material.icons.rounded.Favorite
import androidx.compose.material.icons.rounded.FavoriteBorder
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.KeyboardArrowLeft
import androidx.compose.material.icons.rounded.Menu
import androidx.compose.material.icons.rounded.PlayArrow
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material.icons.rounded.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.draw.scale
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.toRect
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.graphics.drawscope.rotate
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.input.pointer.PointerEventPass
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage
import com.example.cinesmart.Navigation.CineSmartNavController
import com.example.cinesmart.Screens.Screens
import com.example.cinesmart.ui.theme.LocalAppColor
import com.example.cinesmart.ui.theme.LocalAppImage
import com.example.cinesmart.ui.theme.LocalAppPadding
import com.example.cinesmart.ui.theme.LocalAppTypography
import com.example.cinesmart.ui.theme.detectTransformGestures
import com.example.cinesmart.ui.theme.setupPaint
import com.example.cinesmart.ui.theme.shadow
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView
import java.sql.Timestamp


@Composable
fun Background(modifier: Modifier = Modifier) {
    Image(
        painter = painterResource(id = LocalAppImage.current.normal_theme),
        contentDescription = "",
        modifier = Modifier
            .fillMaxSize()
            .blur(50.dp)
    )
}


@Composable
fun ImageWithTags(height: Int, rank: Float? = null, modifier: Modifier = Modifier) {
    //mock data
    val page = 2
    val image = "https://lumiere-a.akamaihd.net/v1/images/p_junglecruise_21740_v2_bb7f0ae4.jpeg"
    val restrict_age = 16
    val top = 1
    //------------
    Box(modifier = Modifier.height(height.dp)) {
        AsyncImage(
            model = image/*ImageRequest.Builder(LocalContext.current).data(sliderList[page])
            .crossfade(true).scale(Scale.FILL).build()*/,
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .height(height.dp)
                .clip(RoundedCornerShape(8.dp)),
            contentScale = ContentScale.Crop
        )

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {

            TagRankAndAge(
                modifier = Modifier.padding(top = 12.dp, start = 12.dp),
                restrict_age = 16
            )
            TagRankAndAge(rank = 8.6f)
        }
    }
}

@Composable
fun TagRankAndAge(modifier: Modifier = Modifier, restrict_age: Int? = null, rank: Float? = null) {
    restrict_age?.let {
        Box(
            modifier = modifier
                .clip(RoundedCornerShape(4.dp))
                .background(LocalAppColor.current.textColorLight)
                .padding(4.dp)
        ) {
            Text(
                text = "$restrict_age+",
                style = LocalAppTypography.current.text_12_bold,
                color = LocalAppColor.current.textBonusColorLight
            )
        }
    }
    rank?.let {
        Box(
            modifier = Modifier
                .padding(top = 12.dp, end = 12.dp)
                .clip(RoundedCornerShape(8.dp))
                .background(LocalAppColor.current.buttonColorDarkCenter)
                .padding(8.dp)
        ) {
            Text(
                text = "$rank",
                style = LocalAppTypography.current.text_14_normal,
                color = LocalAppColor.current.textColorLight
            )
        }
    }
}

@Composable
fun InfoFilm(
    isCenter: Boolean,
    isMaxlineText: Boolean = false,
    isComming: Boolean = false,
    modifier: Modifier = Modifier
) {
    //mock dada
    val nameFilm = "Kẻ Trộm Mặt Trăng"
    val tags = "Hài, Hoạt hình, Phiêu lưu, Gia đình"
    val release_date = "02 August"
    //---------
    Column(
        modifier = Modifier.fillMaxWidth(),
    ) {
        if (isComming) {
            Text(
                text = release_date,
                style = LocalAppTypography.current.text_14_bold,
                color = LocalAppColor.current.textBonusColorLight
            )

        }
        Spacer(modifier = Modifier.padding(2.dp))

        Text(
            text = nameFilm,
            style = LocalAppTypography.current.text_18_bold,
            color = LocalAppColor.current.textColorLight,
            modifier = Modifier.fillMaxWidth(),
            textAlign = if (isCenter) TextAlign.Center else TextAlign.Start,
            maxLines = if (isMaxlineText) 1 else Int.MAX_VALUE,
            overflow = TextOverflow.Ellipsis

        )

        Spacer(modifier = Modifier.padding(2.dp))

        Text(
            text = tags,
            style = LocalAppTypography.current.text_14_thin,
            color = LocalAppColor.current.textBonusColorLight,
            modifier = Modifier.fillMaxWidth(),
            textAlign = if (isCenter) TextAlign.Center else TextAlign.Start,
            maxLines = if (isMaxlineText) 1 else Int.MAX_VALUE,
            overflow = TextOverflow.Ellipsis
        )
    }

}

@Composable
fun MainHeader(modifier: Modifier = Modifier, mainNavHostController: CineSmartNavController) {
    Box(
        modifier = modifier
            .padding(
                start = LocalAppPadding.current.rounded_app_padding.dp,
                end = LocalAppPadding.current.rounded_app_padding.dp,
                top = LocalAppPadding.current.top_app_padding.dp,
                bottom = (LocalAppPadding.current.rounded_app_padding / 2).dp
            )
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            Image(
                painter = painterResource(LocalAppImage.current.logo_app),
                contentDescription = "Logo Application"
            )
            Row(
                modifier = Modifier.weight(1f),
                horizontalArrangement = Arrangement.End,
                verticalAlignment = Alignment.CenterVertically
            ) {
                SearchComponent(Modifier.weight(1f))
                Spacer(modifier = Modifier.padding(8.dp))
                CustomButton(
                    16,
                    "Log in",
                    false,
                    mainNavHostController = mainNavHostController,
                    destinationNavigation = Screens.LoginFragment.route
                )
            }
        }
    }
}

//@Preview
//@Composable
//fun PreviewMain() {
//    MainHeader()
//}

@Composable
fun SearchComponent(modifier: Modifier = Modifier) {
    var searchState by rememberSaveable {
        mutableStateOf(false)
    }
    var searchValue by rememberSaveable {
        mutableStateOf("")
    }
    var focusRequester = remember { FocusRequester() }

    Box(modifier, contentAlignment = Alignment.CenterEnd) {
        AnimatedVisibility(visible = searchState) {
            OutlinedTextField(
                value = searchValue,
                onValueChange = { value -> searchValue = value },
                trailingIcon = {
                    Icon(
                        imageVector = Icons.Rounded.Close,
                        tint = LocalAppColor.current.textColorLight,
                        contentDescription = "Search your film",
                        modifier = Modifier
                            .size(28.dp)
                            .clickable {
                                searchState = !searchState
                            }
                    )
                },
                maxLines = 1,
                modifier = Modifier.height(20.dp)
            )
        }
        if (!searchState) {
            AnimatedVisibility(visible = !searchState, enter = fadeIn(), exit = fadeOut()) {
                Icon(
                    imageVector = Icons.Rounded.Search,
                    tint = LocalAppColor.current.textColorLight,
                    contentDescription = "Search your film",
                    modifier = Modifier
                        .size(28.dp)
                        .clickable {
                            searchState = !searchState
                        }
                )
            }
        }
    }


}

@Composable
fun CustomButton(
    size: Int,
    content: String,
    isFullWidth: Boolean,
    modifier: Modifier = Modifier,
    isNormal: Boolean = false,
    mainNavHostController: CineSmartNavController = CineSmartNavController(rememberNavController()),
    destinationNavigation: String = ""
) {
    if (isFullWidth) {

        Box(
            modifier = modifier
                .clip(RoundedCornerShape(10.dp))
                .background(
                    if (!isNormal) LocalAppColor.current.textColorOrange else LocalAppColor.current.backgroundColorDarkHeader
                )
                .fillMaxWidth()
                .wrapContentHeight()
                .clickable { mainNavHostController.navController.navigate(destinationNavigation) }

                .padding(top = size.dp, bottom = size.dp)
        ) {
            Text(
                text = content,
                style = if (size == 16) LocalAppTypography.current.text_16_bold else LocalAppTypography.current.text_18_bold,
                color = if (!isNormal) LocalAppColor.current.textColorLight else LocalAppColor.current.textColorOrange,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentWidth(),
            )
        }
    } else {
        Box(
            modifier = Modifier
                .clip(RoundedCornerShape(10.dp))
                .background(
                    if (!isNormal) LocalAppColor.current.textColorOrange else LocalAppColor.current.backgroundColorDarkHeader
                )
                .wrapContentHeight()
                .requiredWidth(80.dp)
                .clickable { mainNavHostController.navController.navigate(destinationNavigation) }

                .padding(
                    top = (size - 4).dp,
                    bottom = (size - 4).dp,
                    start = size.dp,
                    end = size.dp
                )

        ) {
            Text(
                text = content,
                style = if (size == 16) LocalAppTypography.current.text_16_bold else LocalAppTypography.current.text_18_bold,
                color = if (!isNormal) LocalAppColor.current.textColorLight else LocalAppColor.current.textColorOrange,
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentSize(),
                maxLines = 1
            )
        }

    }
}


@Composable
fun TopBarTitleAndReturnButton(
    title: String,
    modifier: Modifier = Modifier,
    mainNavHostController: CineSmartNavController
) {
    Row(
        modifier = modifier
    ) {
        Icon(
            imageVector = Icons.Rounded.KeyboardArrowLeft,
            contentDescription = "Back",
            tint = LocalAppColor.current.textBonusColorLight,
            modifier = Modifier.clickable { mainNavHostController.navigateBack() }
        )
        Text(
            text = title,
            style = LocalAppTypography.current.text_18_bold,
            modifier = Modifier.weight(1f),
            textAlign = TextAlign.Center,
            color = LocalAppColor.current.textColorLight
        )
    }
}

@Composable
fun StarAverage(point: Float, type: String) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Icon(
            imageVector = Icons.Rounded.Star,
            contentDescription = "",
            tint = LocalAppColor.current.textColorOrange
        )
        Text(
            text = point.toString(),
            color = LocalAppColor.current.textColorLight,
            style = if (type == "small") LocalAppTypography.current.text_16_bold else LocalAppTypography.current.text_24_bold
        )
        Text(
            text = "/10",
            color = LocalAppColor.current.textBonusColorLight,
            style = if (type == "small") LocalAppTypography.current.text_12_bold else LocalAppTypography.current.text_16_bold
        )
    }
}

@Composable
fun YoutubePlayerComponent(
    videoId: String
) {
    val ctx = LocalContext.current
    AndroidView(factory = {
        var view = YouTubePlayerView(it)
        val fragment = view.addYouTubePlayerListener(
            object : AbstractYouTubePlayerListener() {
                override fun onReady(
                    youTubePlayer: YouTubePlayer
                ) {
                    super.onReady(youTubePlayer)
                    youTubePlayer.cueVideo(videoId, 0f)
                }
            }
        )
        view
    })
}

@Composable
//TODO: fix hard parameter
fun ButtonBottomBar(
    content: String,
    modifier: Modifier = Modifier,
    isNormal: Boolean = false,
    mainNavHostController: CineSmartNavController = CineSmartNavController(
        rememberNavController()
    ),
    destinationNavigation: String = ""
) {
    CustomButton(
        size = 16, content = content, isFullWidth = true, modifier = modifier
            .shadow(
                RoundedCornerShape(10.dp),
                if (!isNormal) LocalAppColor.current.textColorOrange else LocalAppColor.current.textBonusColorLight,
                5.dp,
                0.dp,
                0.dp,
                0.dp
            ),
        isNormal = isNormal,
        mainNavHostController = mainNavHostController,
        destinationNavigation = destinationNavigation
    )
}

@Composable
fun DayElement(time: Timestamp, modifier: Modifier = Modifier, isFocus: Boolean) {
    val dayString = "Mon"
    val dayNum = 21
    Column(
        modifier = modifier
            .width(50.dp)
//            .border(1.dp, LocalAppColor.current.textColorOrange, RoundedCornerShape(20.dp))
            .shadow(
                RoundedCornerShape(10.dp),
                if (isFocus)
                    LocalAppColor.current.buttonColorDarkCenter else Color.Transparent,
                5.dp,
                0.dp,
                0.dp,
                0.dp
            )
            .clip(RoundedCornerShape(10.dp))
    ) {
        Text(
            text = dayString,
            modifier = Modifier
                .fillMaxWidth()
                .background(LocalAppColor.current.backgroundColorDarkHeader)
                .padding(
                    top = (LocalAppPadding.current.rounded_app_padding / 2).dp,
                    bottom = (LocalAppPadding.current.rounded_app_padding / 2).dp
                ),
            textAlign = TextAlign.Center,
            style = LocalAppTypography.current.text_12_bold,
            color = LocalAppColor.current.textBonusColorLight,
        )

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(if (!isFocus) LocalAppColor.current.textColorOrange else LocalAppColor.current.backgroundColorDarkBody)
        ) {
            Text(
                text = dayNum.toString(),
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .padding(
                        top = LocalAppPadding.current.rounded_app_padding.dp,
                        bottom = LocalAppPadding.current.rounded_app_padding.dp
                    ),
                textAlign = TextAlign.Center,
                style = LocalAppTypography.current.text_24_bold,
                color = LocalAppColor.current.textColorLight
            )
        }
    }
}

@Preview
@Composable
fun previewButton() {
    DayElement(
        Timestamp(0, 0, 0, 0, 0, 0, 0), modifier = Modifier.padding(
            LocalAppPadding.current.rounded_app_padding.dp
        ), true
    )
}

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun LikeCommentButton(
    type: String,
    total: Int,
    modifier: Modifier = Modifier,
    onclick: () -> Unit,
    isLiked: Boolean
) {
    Row(
        modifier = modifier.clickable {
            onclick()
        },
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        // TODO: animate
        if (type == "like") {

            AnimatedContent(targetState = isLiked,
                transitionSpec = {
                    scaleIn(
                        initialScale = 0f,
                        animationSpec = tween(200, 2, FastOutLinearInEasing)
                    ).with(
                        scaleOut()
                    )
                }
            ) { target ->
                if (!target) {
                    Icon(
                        modifier = Modifier.size(20.dp),
                        imageVector = Icons.Rounded.FavoriteBorder,
                        contentDescription = "",
                        tint = LocalAppColor.current.textBonusColorLight
                    )

                } else {
                    Icon(
                        modifier = Modifier.size(20.dp),
                        imageVector = Icons.Rounded.Favorite,
                        contentDescription = "",
                        tint = LocalAppColor.current.textColorOrange
                    )
                }

            }
        } else if (type == "comment")
            Icon(
                modifier = Modifier.size(20.dp),
                imageVector = Icons.Outlined.Email,
                contentDescription = "",
                tint = LocalAppColor.current.textBonusColorLight
            )
        else {
            Icon(
                modifier = Modifier.size(20.dp),
                imageVector = Icons.Outlined.Share,
                contentDescription = "",
                tint = LocalAppColor.current.textBonusColorLight
            )
        }
        AnimatedContent(targetState = total, transitionSpec = {
            if (isLiked) {
                slideInVertically { fullHeight -> fullHeight }.with(
                    slideOutVertically { fullHeight -> -fullHeight }
                )
            } else {
                slideInVertically { fullHeight -> -fullHeight }.with(
                    slideOutVertically { fullHeight -> fullHeight }
                )
            }
        }) { targetState ->
            Text(
                text = targetState.toString(),
                color = LocalAppColor.current.textBonusColorLight,
                style = LocalAppTypography.current.text_14_bold
            )
        }
    }
}

@Composable
fun AvatarUserWithFirstLetter(type: String = "large") {
    val firstLetter = "AG"
    Box(
        modifier = Modifier
            .size(if (type == "large") 38.dp else 28.dp)
            .clip(CircleShape)
            .background(LocalAppColor.current.textBonusColorLight),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = firstLetter,
            color = LocalAppColor.current.textColorLight,
            style = if (type == "large") LocalAppTypography.current.text_16_normal else LocalAppTypography.current.text_12_bold
        )
    }
}

@Composable
fun CommentInPostComponent(modifier: Modifier = Modifier) {
    val userImage: String? = null
    val userName: String = "John Davidson"
    val commentBody: String =
        "M thi biet cdb gi. M thi biet cdb gi. M thi biet cdb gi. M thi biet cdb gi. M thi biet cdb gi. M thi biet cdb gi. M thi biet cdb gi. M thi biet cdb gi. M thi biet cdb gi. M thi biet cdb gi. M thi biet cdb gi. M thi biet cdb gi. M thi biet cdb gi. M thi biet cdb gi. M thi biet cdb gi. M thi biet cdb gi. M thi biet cdb gi. M thi biet cdb gi. "
    Row(modifier = Modifier
        .padding(bottom = LocalAppPadding.current.rounded_app_padding.dp)
        .clickable { }) {
        if (userImage != null) {
            AsyncImage(model = userImage, contentDescription = "")
        } else {
            AvatarUserWithFirstLetter(type = "small")
        }
        Spacer(modifier = Modifier.padding((LocalAppPadding.current.rounded_app_padding / 2).dp))
        Column {
            Text(
                text = userName,
                style = LocalAppTypography.current.text_14_bold,
                color = LocalAppColor.current.textColorLight
            )
            Spacer(modifier = Modifier.padding(top = (LocalAppPadding.current.rounded_app_padding / 2).dp))
            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(8.dp))
                    .background(LocalAppColor.current.backgroundColorDarkHeader)
                    .padding((LocalAppPadding.current.rounded_app_padding / 2).dp)
            ) {

                Text(
                    text = commentBody,
                    style = LocalAppTypography.current.text_14_normal,
                    color = LocalAppColor.current.textBonusColorLight
                )
            }
        }
    }
}

@Composable
fun DayFilterRowComponent(modifier: Modifier = Modifier) {
    val listDay = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    LazyRow(
        modifier = modifier

    ) {
        itemsIndexed(listDay) { index, item ->
            DayElement(
                Timestamp(0, 0, 0, 0, 0, 0, 0), modifier = Modifier.padding(
                    LocalAppPadding.current.rounded_app_padding.dp
                ),
                false
            )
            DayElement(
                Timestamp(0, 0, 0, 0, 0, 0, 0), modifier = Modifier.padding(
                    LocalAppPadding.current.rounded_app_padding.dp
                ),
                true
            )
        }
    }
}


@Preview
@Composable
fun PreviewCommentComposable() {
    CommentInPostComponent()
}


@Composable
fun GridPickSeat() {
    // set up all transformation states
    var scale by remember { mutableStateOf(1f) }
    var offset by remember { mutableStateOf(Offset.Zero) }
    val state = rememberTransformableState { zoomChange, offsetChange, rotationChange ->
        scale *= zoomChange
        offset += offsetChange
    }
    val cols = 40
    val rows = 30
    Column(
        Modifier
            .graphicsLayer(
                scaleX = if (scale < .5f) .5f else if (scale > 3f) 3f else scale,
                scaleY = if (scale < .5f) .5f else if (scale > 3f) 3f else scale,
                translationX = if (offset.x > 600f) 600f else if (offset.x < -600f) -600f else offset.x,
                translationY = if (offset.y > 600f) 600f else if (offset.y < -600f) -600f else offset.y
            )
            .transformable(state = state)
            .fillMaxWidth()
            .height(500.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Screen")
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            for (i in 1..cols) {
                Row {
                    for (j in 1..rows) {
                        Box(
                            modifier = Modifier
                                .weight(1f)
                                .wrapContentHeight()
                                .background(LocalAppColor.current.textColorOrange)
                        ) {
                            Text(text = "U")
                        }
                    }
                }
            }
        }
    }

}

@Composable
fun ZoomableGridDemo() {
    var scale by remember { mutableStateOf(1f) }
    var offset by remember { mutableStateOf(Offset(0f, 0f)) }
    val cols = 5
    val rows = 10
    Box(
        modifier = Modifier.background(LocalAppColor.current.backgroundColorDarkBody),
        contentAlignment = Alignment.TopEnd
    ) {
        Box(
            modifier = Modifier

                .fillMaxWidth()
                .aspectRatio(1f)
                .pointerInput(Unit) {
                    detectTransformGestures(
                        pass = PointerEventPass.Initial,
                        onGesture = { _, pan, zoom, _ ->

                            scale =
                                if (scale < 0.8f) 0.8f else if (scale > 1.5f) 1.5f else scale * zoom
                            offset = Offset(
                                if (offset.x > 400f) 400f else if (offset.x < -400f) -400f else offset.x + pan.x,
                                if (offset.y > 400f) 400f else if (offset.y < -400f) -400f else offset.y + pan.y
                            )
                        })

                }
                .clip(RoundedCornerShape(0.dp)),
            contentAlignment = Alignment.Center
        ) {
            // Khu vực để hiển thị grid
            Box(
                modifier = Modifier

                    .graphicsLayer(
                        scaleX = if (scale > 1.5f) 1.5f else if (scale < 0.8f) 0.8f else scale,
                        scaleY = if (scale > 1.5f) 1.5f else if (scale < 0.8f) 0.8f else scale,
                        translationX = if (offset.x > 400f) 400f else if (offset.x < -400f) -400f else offset.x,
                        translationY = if (offset.y > 400f) 400f else if (offset.y < -400f) -400f else offset.y
                    )
            ) {
                // Ví dụ tạo một grid đơn giản
                GridView(cols, rows)
            }

            // Màn hình thu nhỏ hiển thị vị trí hiện tại
        }
        SmallView(scale, offset, cols = cols, rows = rows)
    }

}

@Composable
fun GridView(cols: Int, rows: Int) {
    // Xây dựng grid đơn giản (ví dụ 10x10 ô vuông)
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(
            text = "SCREEN",
            style = LocalAppTypography.current.text_20_normal,
            color = LocalAppColor.current.textBonusColorLight
        )
//        Spacer(modifier = Modifier.padding(LocalAppPadding.current.rounded_app_padding.dp))
        for (i in 0..cols) {
            Row {
                for (j in 0..rows) {
                    Seat()
                }
            }
        }
    }
}

@Composable
fun RowScope.Seat(modifier: Modifier = Modifier) {
    Box(
        modifier = Modifier
            .weight(1f)
            .aspectRatio(1f)
            .padding(4.dp)
    ) {
        //TODO: Move mock data to specific place
        val type = rememberSaveable {
            mutableStateOf("Available")
        }
        Box(
            modifier = Modifier
                .fillMaxSize()
                .shadow(
                    RoundedCornerShape(10.dp),
                    if (type.value == "Chosen")
                        LocalAppColor.current.textColorOrange else LocalAppColor.current.backgroundColorDarkHeader,
                    5.dp,
                    0.dp,
                    0.dp,
                    0.dp
                )
                .clip(
                    RoundedCornerShape(10.dp)
                )
                .background(if (type.value == "Chosen") LocalAppColor.current.textColorOrange else LocalAppColor.current.backgroundColorDarkHeader)
                .clickable {
                    if (type.value == "Available") {
                        type.value = "Chosen"
                    } else if (type.value == "Chosen") {
                        type.value = "Available"
                    }
                },
            contentAlignment = Alignment.Center

        ) {
            if (type.value == "Occupied") {
                Icon(
                    imageVector = Icons.Rounded.Close,
                    contentDescription = "",
                    modifier = Modifier.size(10.dp),
                    tint = LocalAppColor.current.textBonusColorLight
                )
            }
        }

    }
}

@Composable
fun SmallView(scale: Float, offset: Offset, cols: Int, rows: Int) {
    Box(
        modifier = Modifier
            .padding(
                LocalAppPadding.current.rounded_app_padding.dp
            )
            .fillMaxWidth(0.25f)
            .aspectRatio(1f)
            .background(Color.Black)
            .clip(shape = RoundedCornerShape(0.dp))
    ) {
        // Khu vực để hiển thị grid
        Box(
            modifier = Modifier
                .fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(
                    text = "SCREEN",
                    style = LocalAppTypography.current.text_12_bold,
                    color = LocalAppColor.current.textColorLight,
                    modifier = Modifier.scale(0.5f)
                )
                for (i in 0..cols) {
                    Row {
                        for (j in 0..rows) {
                            Box(
                                modifier = Modifier
                                    .weight(1f)
                                    .aspectRatio(1f)
                                    .padding((1).dp)
                                    .clip(RoundedCornerShape(2.dp))

                                    .background(Color.Gray)
                            )
                        }
                    }
                }
            }
        }
        Box(
            modifier = Modifier
                .fillMaxSize()
                .graphicsLayer(
                    scaleX = if (scale > 1.5f) 1 / 1.5f else if (scale < 0.8f) 1 / 0.8f else 1 / scale,
                    scaleY = if (scale > 1.5f) 1 / 1.5f else if (scale < 0.8f) 1 / 0.8f else 1 / scale,
                    translationX = -(if (offset.x > 400f) 400f else if (offset.x < -400f) -400f else offset.x) / 4f,
                    translationY = -(if (offset.y > 400f) 400f else if (offset.y < -400f) -400f else offset.y) / 4f
                )
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .border(1.dp, LocalAppColor.current.textColorOrange, RoundedCornerShape(0.dp))
            ) {

            }
        }
    }
}


@Composable
fun FilmPerformInfoTopBar(modifier: Modifier = Modifier) {
    val nameFilm = "The Batman"
    val dayPerform = "April 14"
    val timePerform = "15:10"
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = nameFilm,
            style = LocalAppTypography.current.text_24_bold,
            color = LocalAppColor.current.textColorLight,
            modifier = Modifier.padding(
                start = LocalAppPadding.current.rounded_app_padding.dp,
                end = LocalAppPadding.current.rounded_app_padding.dp,
                bottom = LocalAppPadding.current.rounded_app_padding.dp,
            )
        )
        Row(
            horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier.padding(
                LocalAppPadding.current.rounded_app_padding.dp
            )
        ) {
            Row(
                modifier = Modifier
                    .weight(1f)
                    .border(
                        1.dp,
                        LocalAppColor.current.textBonusColorLight,
                        RoundedCornerShape(4.dp)
                    )
                    .padding((LocalAppPadding.current.rounded_app_padding).dp),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically

            ) {
                Icon(
                    imageVector = Icons.Rounded.DateRange,
                    contentDescription = "",
                    tint = LocalAppColor.current.textColorLight
                )
                Text(
                    text = dayPerform,
                    style = LocalAppTypography.current.text_18_bold,
                    color = LocalAppColor.current.textColorLight
                )
            }
            Spacer(modifier = Modifier.padding(LocalAppPadding.current.rounded_app_padding.dp))
            Row(
                modifier = Modifier
                    .weight(1f)
                    .border(
                        1.dp,
                        LocalAppColor.current.textBonusColorLight,
                        RoundedCornerShape(4.dp)
                    )
                    .padding(
                        LocalAppPadding.current.rounded_app_padding.dp
                    ),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = Icons.Rounded.PlayArrow,
                    contentDescription = "",
                    tint = LocalAppColor.current.textColorLight
                )
                Text(
                    text = dayPerform,
                    style = LocalAppTypography.current.text_18_bold,
                    color = LocalAppColor.current
                        .textColorLight
                )
            }
        }
    }
}

@Composable
fun Node(type: String) {
    Box(
        modifier = Modifier
            .size(20.dp)
            .background(if (type == "Chosen") LocalAppColor.current.backgroundColorDarkHeader else Color.Transparent)
            .shadow(
                CircleShape,
                if (type == "Chosen") LocalAppColor.current.textColorOrange else Color.Transparent,
                5.dp,
                0.dp,
                0.dp,
                0.dp
            )
    ) {
        Box(
            modifier = Modifier
                .size(20.dp)
                .clip(CircleShape)
                .background(if (type == "Chosen") LocalAppColor.current.textColorOrange else LocalAppColor.current.backgroundColorDarkHeader),
            contentAlignment = Alignment.Center
        ) {
            if (type == "Occupied") {
                Icon(
                    imageVector = Icons.Rounded.Close,
                    contentDescription = "",
                    tint = LocalAppColor.current.textBonusColorLight,
                    modifier = Modifier.size(10.dp)
                )
            }
        }

    }
}

@Composable
fun TypeOfSeat(type: String) {
    Row {
        Node(type)
        Spacer(modifier = Modifier.padding((LocalAppPadding.current.rounded_app_padding / 4).dp))
        Text(
            text = type,
            style = LocalAppTypography.current.text_16_bold,
            color = LocalAppColor.current.textBonusColorLight
        )
    }
}

data class StrokeStyle(
    val width: Dp = 4.dp,
    val strokeCap: StrokeCap = StrokeCap.Round,
    val glowRadius: Dp? = 4.dp
)


@Composable
fun CircleLoader(
    modifier: Modifier = Modifier,
    isVisible: Boolean,
    color: Color,
    secondColor: Color? = color,
    tailLength: Float = 140f,
    smoothTransition: Boolean = true,
    strokeStyle: StrokeStyle = StrokeStyle(),
    cycleDuration: Int = 1400
) {
    val transition = rememberInfiniteTransition()
    val spinAngel by transition.animateFloat(
        initialValue = 0f,
        targetValue = 360f,
        animationSpec = infiniteRepeatable(
            animation = tween(
                durationMillis = cycleDuration,
                easing = LinearEasing
            ),
            repeatMode = RepeatMode.Restart
        ), label = ""
    )
    val tailToDisplay = remember { Animatable(0f) }

    LaunchedEffect(isVisible) {
        val targetTail = if (isVisible) tailLength else 0f
        when {
            smoothTransition -> tailToDisplay.animateTo(
                targetValue = targetTail,
                animationSpec = tween(cycleDuration, easing = LinearEasing)
            )

            else -> tailToDisplay.snapTo(targetTail)
        }
    }
    Canvas(
        modifier
            // Apply rotation animation
            .rotate(spinAngel)
            // Ensure the CircleLoader maintains a square aspect ratio
            .aspectRatio(1f)
    ) {
        // Iterate over non-null colors
        listOfNotNull(color, secondColor).forEachIndexed { index, color ->
            // If it's not a primary color we rotate the canvas for 180 degrees
            rotate(if (index == 0) 0f else 180f) {
                // Create a sweep gradient brush for the loader
                val brush = Brush.sweepGradient(
                    0f to Color.Transparent,
                    tailToDisplay.value / 360f to color,
                    1f to Color.Transparent
                )
                // Set up paint object
                val paint = setupPaint(strokeStyle, brush)

                // Draw the loader tail
                drawIntoCanvas { canvas ->
                    canvas.drawArc(
                        rect = size.toRect(),
                        startAngle = 0f,
                        sweepAngle = tailToDisplay.value,
                        useCenter = false,
                        paint = paint
                    )
                }
            }
        }
    }
}

@Composable
fun TagString(modifier: Modifier = Modifier, seatName: String) {
    Box(
        modifier = Modifier
            .wrapContentSize()
            .clip(RoundedCornerShape(4.dp))
            .background(
                LocalAppColor.current.textColorLight
            )
            .padding((LocalAppPadding.current.rounded_app_padding / 2).dp)
    ) {
        Text(
            text = seatName,
            style = LocalAppTypography.current.text_16_bold,
            color = LocalAppColor.current.backgroundColorDarkBody
        )
    }
}

@Composable
fun NormalTextField(
    modifier: Modifier = Modifier,
    value: String,
    label: String,
    leadingIcon: ImageVector,
    isLast: Boolean = false,
    changeValue: (String) -> Unit
) {
    val isFocus = rememberSaveable {
        mutableStateOf(true)
    }
    androidx.compose.material.OutlinedTextField(
        value = value,
        keyboardOptions = KeyboardOptions(imeAction = if (!isLast) ImeAction.Next else ImeAction.Done),
        modifier = Modifier
            .padding(
                start = (2 * LocalAppPadding.current.rounded_app_padding).dp,
                end = (2 * LocalAppPadding.current.rounded_app_padding).dp,
                top = LocalAppPadding.current.rounded_app_padding.dp,
                bottom = LocalAppPadding.current.rounded_app_padding.dp
            )
            .fillMaxWidth()
            .onFocusChanged {
                isFocus.value = !isFocus.value
            },
        singleLine = true,
        label = {
            Text(
                text = label,
                style = LocalAppTypography.current.text_12_bold,
                color = if (isFocus.value) LocalAppColor.current.textColorOrange else LocalAppColor.current.textBonusColorLight
            )
        },
        onValueChange = { changeValue(it) },
        shape = RoundedCornerShape(10.dp),
        leadingIcon = {
            Icon(
                imageVector = leadingIcon,
                contentDescription = "",
                tint = if (isFocus.value) LocalAppColor.current.textColorOrange else LocalAppColor.current.textBonusColorLight
            )
        },
        colors = TextFieldDefaults.textFieldColors(
            cursorColor = LocalAppColor.current.textColorOrange,
            disabledTextColor = LocalAppColor.current.textBonusColorLight,
            backgroundColor = LocalAppColor.current.textColorOrange.copy(alpha = .2f),
            focusedIndicatorColor = LocalAppColor.current.textColorOrange,
            unfocusedIndicatorColor = LocalAppColor.current.textBonusColorLight,
            textColor = LocalAppColor.current.textColorOrange,
        ),
        textStyle = LocalAppTypography.current.text_18_bold.copy(color = LocalAppColor.current.textColorOrange),
    )
}


@Composable
fun shimmerBrush(showShimmer: Boolean = true, targetValue: Float = 1000f): Brush {
    return if (showShimmer) {
        val shimmerColors = listOf(
            Color.LightGray.copy(alpha = 0.6f),
            Color.LightGray.copy(alpha = 0.2f),
            Color.LightGray.copy(alpha = 0.6f),
        )
        val transition = rememberInfiniteTransition()
        val translateAnimation = transition.animateFloat(
            initialValue = 0f,
            targetValue = targetValue,
            animationSpec = infiniteRepeatable(
                animation = tween(800), repeatMode = RepeatMode.Reverse
            )
        )
        Brush.linearGradient(
            colors = shimmerColors,
            start = Offset.Zero,
            end = Offset(x = translateAnimation.value, y = translateAnimation.value)
        )
    } else {
        Brush.linearGradient(
            colors = listOf(Color.Transparent, Color.Transparent),
            start = Offset.Zero,
            end = Offset.Zero
        )
    }
}


@Composable
fun MainBottomBar(navController: NavController) {
    val itemSelected = rememberSaveable{
        mutableStateOf("HOME")
    }
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(LocalAppColor.current.backgroundColorDarkBody)
            .padding(
                bottom = (LocalAppPadding.current.top_app_padding / 2).dp,
                top = LocalAppPadding.current.rounded_app_padding.dp
            ), horizontalArrangement = Arrangement.SpaceAround
    ) {
        Icon(imageVector = Icons.Rounded.Home, contentDescription = "", modifier = Modifier
            .size(30.dp)
            .clickable {
                navController.navigate(Screens.SelectFilmScreen.route) {
                    launchSingleTop = true
                    restoreState = true
                }
                itemSelected.value = "HOME"
            }, tint = if(itemSelected.value == "HOME") LocalAppColor.current.backgroundColorDarkHeader else LocalAppColor.current.textBonusColorLight)
        Icon(imageVector = Icons.Rounded.Menu, contentDescription = "", modifier = Modifier
            .size(30.dp)
            .clickable {
                navController.navigate(Screens.SelectTheaterScreen.route) {
                    launchSingleTop = true
                    restoreState = true
                }
                itemSelected.value = "MENU"
            }, tint = if(itemSelected.value == "MENU") LocalAppColor.current.backgroundColorDarkHeader else LocalAppColor.current.textBonusColorLight
        )
        Icon(imageVector = Icons.Rounded.AccountCircle, contentDescription = "", modifier = Modifier
            .size(30.dp)
            .clickable {
                navController.navigate(Screens.UserInfoScreen.route) {
                    launchSingleTop = true
                    restoreState = true
                }
                itemSelected.value = "ACCOUNT"
            }, tint = if(itemSelected.value == "ACCOUNT") LocalAppColor.current.backgroundColorDarkHeader else LocalAppColor.current.textBonusColorLight
        )
    }
}

@Composable
fun hideSystemNavBars() {
    val view = LocalView.current
    val windowInfo = LocalContext.current

    LaunchedEffect(key1 = Unit, block = {
        val act = windowInfo as? Activity
        act?.let {
            val window = WindowCompat.getInsetsController(it.window, view)
            window.hide(WindowInsetsCompat.Type.navigationBars())
        }
    })
}

@Composable
@Preview
fun PreviewGridPickSeat() {
    MainBottomBar(rememberNavController())
}
