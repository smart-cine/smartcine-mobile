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
import com.example.cinesmart.Screens.PickseatScreen
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
//        PickseatScreen()
        Box(modifier = Modifier.fillMaxSize().background(LocalAppColor.current.backgroundColorDarkBody), contentAlignment = Alignment.Center){
            CircleLoader(
                color = LocalAppColor.current.textColorOrange,
                modifier = Modifier.size(50.dp),
                isVisible = true
            )
        }

    }
}

@Composable
fun ZoomableGrid() {
    var scale by remember { mutableStateOf(1f) }
    var offset by remember { mutableStateOf(Offset(0f, 0f)) }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .pointerInput(Unit) {
                detectTransformGestures { _, pan, zoom, _ ->
                    scale *= zoom
                    offset = Offset(offset.x + pan.x, offset.y + pan.y)
                }
            }
            .graphicsLayer(
                scaleX = scale,
                scaleY = scale,
                translationX = offset.x,
                translationY = offset.y
            )
    ) {
        // Your grid of seats
        LazyVerticalGrid(
            // Configure your grid here
            modifier = Modifier.fillMaxSize(), columns = GridCells.Fixed(2)) {
            items(100) { index ->
                SeatButton(index) // Your Composable for each seat
            }
        }
    }
}

@Composable
fun SeatButton(index: Int) {
    Box(
        modifier = Modifier
            .size(50.dp)
            .clickable {
                // Handle seat click event
                println("Seat $index clicked")
            }
    ) {
        // Represent the seat (e.g., as a Text or Image)
        Text(text = "Seat $index")
    }
}