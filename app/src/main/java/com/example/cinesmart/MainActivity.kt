package com.example.cinesmart

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.cinesmart.Components.hideSystemNavBars
import com.example.cinesmart.Screens.SelectFilmScreen
import com.example.cinesmart.Screens.SelectTheaterScreen
import com.example.cinesmart.Screens.WelcomeScreen
import com.example.cinesmart.ui.theme.CineSmartTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CineSmartTheme {
                MyApp()
            }
        }
    }
}


