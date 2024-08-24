package com.example.cinesmart

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import com.example.cinesmart.Screens.SelectFilmScreen
import com.example.cinesmart.Screens.WelcomeScreen
import com.example.cinesmart.ui.theme.CineSmartTheme

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

