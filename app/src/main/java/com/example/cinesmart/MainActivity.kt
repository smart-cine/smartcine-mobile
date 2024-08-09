package com.example.cinesmart

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.cinesmart.Components.CarouselCard
import com.example.cinesmart.Components.CommentComponent
import com.example.cinesmart.Components.FilmDescriptionBlock
import com.example.cinesmart.Components.ImageFilmAndInfoComponent
import com.example.cinesmart.Screens.AllCommentsScreen
import com.example.cinesmart.Screens.FilmInfoScreen
import com.example.cinesmart.Screens.SelectFilmScreen
import com.example.cinesmart.Screens.WelcomeScreen
import com.example.cinesmart.ui.theme.CineSmartTheme
import java.sql.Timestamp

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
fun MainApp(){
    var loading = rememberSaveable {
        mutableStateOf(true)
    }
    if (loading.value){
        WelcomeScreen({loading.value = false })
    } else{
        FilmInfoScreen()
    }
}

