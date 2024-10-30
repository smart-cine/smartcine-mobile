package com.example.cinesmart.Screens

import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.cinesmart.Components.hideSystemNavBars
import com.example.cinesmart.R
import com.example.cinesmart.ui.theme.LocalAppColor
import com.example.cinesmart.ui.theme.LocalAppImage
import kotlinx.coroutines.Delay
import kotlinx.coroutines.delay

@Composable
fun WelcomeScreen() {
    val infiniteTransition = rememberInfiniteTransition()
    val scaleAnimation by infiniteTransition.animateFloat(
        initialValue = 1.5f,
        targetValue = 2.5f,
        animationSpec = infiniteRepeatable(
            animation = tween(1000),
            repeatMode = RepeatMode.Reverse
        )
    )
    hideSystemNavBars()
    Box(modifier = Modifier
        .fillMaxSize()){
        Image(painter = painterResource(LocalAppImage.current.normal_theme), contentDescription = "", modifier = Modifier
            .fillMaxSize()
            .blur(50.dp))
        Box(modifier = Modifier
            .fillMaxSize()
            .background(LocalAppColor.current.backgroundColorDarkBody.copy(alpha = 0.8f))) {
            Image(
                painter = painterResource(R.drawable.product_logo),
                contentDescription = "Logo",
                modifier = Modifier
                    .fillMaxSize()
                    .wrapContentSize()
                    .scale(scaleAnimation)
            )
        }
    }
}
