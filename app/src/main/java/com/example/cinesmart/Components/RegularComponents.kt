package com.example.cinesmart.Components

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.FastOutLinearInEasing
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.animation.with
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Share
import androidx.compose.material.icons.rounded.Close
import androidx.compose.material.icons.rounded.Favorite
import androidx.compose.material.icons.rounded.FavoriteBorder
import androidx.compose.material.icons.rounded.KeyboardArrowLeft
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material.icons.rounded.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import coil.compose.AsyncImage
import com.example.cinesmart.ui.theme.LocalAppColor
import com.example.cinesmart.ui.theme.LocalAppImage
import com.example.cinesmart.ui.theme.LocalAppPadding
import com.example.cinesmart.ui.theme.LocalAppTypography
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
fun MainHeader(modifier: Modifier = Modifier) {
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
                CustomButton(16, "Log in", false)
            }
        }
    }
}

@Preview
@Composable
fun PreviewMain() {
    MainHeader()
}

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
fun CustomButton(size: Int, content: String, isFullWidth: Boolean, modifier: Modifier = Modifier) {
    if (isFullWidth) {

        Box(
            modifier = modifier
                .clip(RoundedCornerShape(10.dp))
                .background(
                    LocalAppColor.current.textColorOrange
                )
                .fillMaxWidth()
                .wrapContentHeight()
                .padding(top = (size / 2).dp, bottom = (size / 2).dp)
        ) {
            Text(
                text = content,
                style = if (size == 16) LocalAppTypography.current.text_16_bold else LocalAppTypography.current.text_18_bold,
                color = LocalAppColor.current.textColorLight,
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
                    LocalAppColor.current.buttonColorDarkCenter
                )
                .wrapContentHeight()
                .requiredWidth(80.dp)
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
                color = LocalAppColor.current.textColorLight,
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentSize(),
                maxLines = 1
            )
        }

    }
}


@Composable
fun TopBarTitleAndReturnButton(title: String, modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
    ) {
        Icon(
            imageVector = Icons.Rounded.KeyboardArrowLeft,
            contentDescription = "Back",
            tint = LocalAppColor.current.textBonusColorLight,
            modifier = Modifier.clickable { }
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
fun ButtonBottomBar() {
    CustomButton(
        size = 16, content = "Select session", isFullWidth = true, modifier = Modifier
            .shadow(
                RoundedCornerShape(10.dp),
                LocalAppColor.current.buttonColorDarkCenter,
                5.dp,
                0.dp,
                0.dp,
                0.dp
            )
            .clickable { }
    )
}
@Composable
fun DayElement(time: Timestamp, modifier: Modifier = Modifier, isFocus:Boolean) {
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
                .background(if (!isFocus)LocalAppColor.current.textColorOrange else LocalAppColor.current.backgroundColorDarkBody)
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
fun previewButton(){
    DayElement(Timestamp(0, 0, 0, 0, 0, 0, 0), modifier = Modifier.padding(
        LocalAppPadding.current.rounded_app_padding.dp), true)
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
fun AvatarUserWithFirstLetter(type:String = "large"){
    val firstLetter = "AG"
    Box(
        modifier = Modifier
            .size(if (type == "large") 38.dp else 28.dp)
            .clip(CircleShape)
            .background(LocalAppColor.current.textBonusColorLight),
        contentAlignment = Alignment.Center
    ) {
        Text(text = firstLetter, color = LocalAppColor.current.textColorLight, style = if(type == "large") LocalAppTypography.current.text_16_normal else LocalAppTypography.current.text_12_bold)
    }
}
@Composable
fun CommentInPostComponent(modifier: Modifier = Modifier){
    val userImage:String? = null
    val userName:String = "John Davidson"
    val commentBody:String = "M thi biet cdb gi. M thi biet cdb gi. M thi biet cdb gi. M thi biet cdb gi. M thi biet cdb gi. M thi biet cdb gi. M thi biet cdb gi. M thi biet cdb gi. M thi biet cdb gi. M thi biet cdb gi. M thi biet cdb gi. M thi biet cdb gi. M thi biet cdb gi. M thi biet cdb gi. M thi biet cdb gi. M thi biet cdb gi. M thi biet cdb gi. M thi biet cdb gi. "
    Row(modifier = Modifier.padding(bottom = LocalAppPadding.current.rounded_app_padding.dp).clickable {  }) {
        if (userImage!=null){
            AsyncImage(model = userImage, contentDescription = "")
        } else{
            AvatarUserWithFirstLetter(type = "small")
        }
        Spacer(modifier = Modifier.padding((LocalAppPadding.current.rounded_app_padding/2).dp))
        Column {
            Text(text = userName, style = LocalAppTypography.current.text_14_bold, color = LocalAppColor.current.textColorLight)
            Spacer(modifier = Modifier.padding(top = (LocalAppPadding.current.rounded_app_padding/2).dp))
            Box(modifier = Modifier
                .clip(RoundedCornerShape(8.dp))
                .background(LocalAppColor.current.backgroundColorDarkHeader)
                .padding((LocalAppPadding.current.rounded_app_padding / 2).dp)){

                Text(text = commentBody, style = LocalAppTypography.current.text_14_normal, color = LocalAppColor.current.textBonusColorLight)
            }
        }
    }
}

@Composable
fun DayFilterRowComponent(modifier: Modifier = Modifier){
    val listDay = listOf(1,2,3,4,5,6,7,8,9,10)
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
fun PreviewRegularComposable() {
    ButtonBottomBar()
}
@Preview
@Composable
fun PreviewCommentComposable(){
    CommentInPostComponent()
}

