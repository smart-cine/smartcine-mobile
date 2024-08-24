package com.example.cinesmart

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectTransformGestures
import androidx.compose.foundation.gestures.rememberTransformableState
import androidx.compose.foundation.gestures.transformable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material.BottomNavigation
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.unit.dp
import com.example.cinesmart.Components.CircleLoader
import com.example.cinesmart.Components.GridPickSeat
import com.example.cinesmart.Components.TypeOfSeat
import com.example.cinesmart.Components.ZoomableGridDemo
import com.example.cinesmart.Screens.FilmInfoScreen
import com.example.cinesmart.Screens.LoginScreen
import com.example.cinesmart.Screens.PaymentScreen
import com.example.cinesmart.Screens.PaymentSuccessScreen
import com.example.cinesmart.Screens.PickseatScreen
import com.example.cinesmart.Screens.ProfileScreen
import com.example.cinesmart.Screens.RegisterScreen
import com.example.cinesmart.Screens.SelectFilmPerTheaterScreen
import com.example.cinesmart.Screens.SelectFilmScreen
import com.example.cinesmart.Screens.SelectTheaterScreen
import com.example.cinesmart.Screens.WelcomeScreen
import com.example.cinesmart.ui.theme.CineSmartTheme
import com.example.cinesmart.ui.theme.LocalAppColor

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CineSmartTheme {

                MainApp()
            }
            //may be set button navigation bar here to not be reloaded while navigating
        }
    }
}

@Composable
fun MainApp() {
    var loading = rememberSaveable {
        mutableStateOf(true)
    }
    if (loading.value) {
        WelcomeScreen({ loading.value = false })
    } else {
        SelectFilmScreen()
    }
//    BottomNavigation {
//
//    }
}

