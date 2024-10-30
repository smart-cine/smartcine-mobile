package com.example.cinesmart

import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.SharedTransitionScope
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.cinesmart.Components.CircleLoader
import com.example.cinesmart.Components.MainBottomBar
import com.example.cinesmart.Navigation.CineSmartNavController
import com.example.cinesmart.Navigation.rememberCineSmartNavController
import com.example.cinesmart.Screens.AllCommentsScreen
import com.example.cinesmart.Screens.FilmInfoScreen
import com.example.cinesmart.Screens.LoginScreen
import com.example.cinesmart.Screens.PaymentScreen
import com.example.cinesmart.Screens.PaymentSuccessScreen
import com.example.cinesmart.Screens.PickseatScreen
import com.example.cinesmart.Screens.ProfileScreen
import com.example.cinesmart.Screens.RegisterScreen
import com.example.cinesmart.Screens.Screens
import com.example.cinesmart.Screens.SelectFilmPerTheaterScreen
import com.example.cinesmart.Screens.SelectFilmScreen
import com.example.cinesmart.Screens.SelectTheaterScreen
import com.example.cinesmart.Screens.WelcomeScreen
import com.example.cinesmart.ui.theme.LocalAppColor
import kotlinx.coroutines.delay

@OptIn(ExperimentalSharedTransitionApi::class)
@Composable
fun MyApp(
) {
    var navHostController = rememberCineSmartNavController()
    SharedTransitionScope {
        val isMainLoading = remember {
            mutableStateOf(true)
        }
        val changeState = {isMainLoading.value = false
        }
        LaunchedEffect(changeState) {
            delay(1000)
            changeState()
        }
        if (isMainLoading.value){
            WelcomeScreen()
        }else{
            NavHost(
                navController = navHostController.navController,
                startDestination = Screens.FilmFragment.route
            ) {
                composable(route = Screens.FilmFragment.route){
                    MainScreens(mainNavHostController = navHostController)
                }
                composable(route = Screens.LoginFragment.route){
                    LoginFragment(mainNavHostController = navHostController)
                }
                composable(route = Screens.FilmInfoScreen.route,
                    enterTransition = { slideInHorizontally(initialOffsetX = { it / 2 }) + fadeIn() }){
                    val isLoading = remember {
                        mutableStateOf(true)
                    }
                    val changeState = {isLoading.value = false
                    }
                    LaunchedEffect(changeState) {
                        delay(1000)
                        changeState()
                    }
                    if (isLoading.value){
                        WelcomeScreen()
                    }else FilmInfoScreen(mainNavHostController = navHostController)
                }
                composable(route = Screens.PaymentScreen.route,
                    enterTransition = { slideInHorizontally(initialOffsetX = { it / 2 }) + fadeIn() }){
                    val isLoading = remember {
                        mutableStateOf(true)
                    }
                    val changeState = {isLoading.value = false
                    }
                    LaunchedEffect(changeState) {
                        delay(1000)
                        changeState()
                    }
                    if (isLoading.value){
                        WelcomeScreen()
                    }else
                        PaymentScreen(mainNavHostController = navHostController)
                }
                composable(route = Screens.PaymentSuccessScreen.route,
                    enterTransition = { slideInHorizontally(initialOffsetX = { it / 2 }) + fadeIn() }){
                    val isLoading = remember {
                        mutableStateOf(true)
                    }
                    val changeState = {isLoading.value = false
                    }
                    LaunchedEffect(changeState) {
                        delay(1000)
                        changeState()
                    }
                    if (isLoading.value){
                        WelcomeScreen()
                    }else
                        PaymentSuccessScreen(mainNavHostController = navHostController)
                }
                composable(route = Screens.SelectFilmPerTheaterScreen.route,
                    enterTransition = { slideInHorizontally(initialOffsetX = { it / 2 }) + fadeIn() }){
                    val isLoading = remember {
                        mutableStateOf(true)
                    }
                    val changeState = {isLoading.value = false
                    }
                    LaunchedEffect(changeState) {
                        delay(1000)
                        changeState()
                    }
                    if (isLoading.value){
                        WelcomeScreen()
                    }else
                        SelectFilmPerTheaterScreen(mainNavHostController = navHostController)
                }
                composable(route = Screens.AllCommentScreen.route,
                    enterTransition = { slideInHorizontally(initialOffsetX = { it / 2 }) + fadeIn() }){
                    val isLoading = remember {
                        mutableStateOf(true)
                    };
                    val onTimeout = { isLoading.value = false }
                    LaunchedEffect(onTimeout) {
                        //Fetch data Select film screen
                        delay(500)
                        onTimeout()
                    }
                    if (isLoading.value) {
                        WelcomeScreen()
                    } else AllCommentsScreen(mainNavHostController = navHostController)
                }
                composable(route = Screens.PickSeatScreen.route,
                    enterTransition = { slideInHorizontally(initialOffsetX = { it / 2 }) + fadeIn() }){
                    val isLoading = remember {
                        mutableStateOf(true)
                    };
                    val onTimeout = { isLoading.value = false }
                    LaunchedEffect(onTimeout) {
                        //Fetch data Select film screen
                        delay(500)
                        onTimeout()
                    }
                    if (isLoading.value) {
                        WelcomeScreen()
                    } else PickseatScreen(mainNavHostController = navHostController)
                }
                composable(route = Screens.PaymentScreen.route,
                    enterTransition = { slideInHorizontally(initialOffsetX = { it / 2 }) + fadeIn() }){
                    val isLoading = remember {
                        mutableStateOf(true)
                    };
                    val onTimeout = { isLoading.value = false }
                    LaunchedEffect(onTimeout) {
                        //Fetch data Select film screen
                        delay(500)
                        onTimeout()
                    }
                    if (isLoading.value) {
                        WelcomeScreen()
                    } else PaymentScreen(mainNavHostController = navHostController)
                }
                composable(route = Screens.PaymentSuccessScreen.route,
                    enterTransition = { slideInHorizontally(initialOffsetX = { it / 2 }) + fadeIn() }){
                    val isLoading = remember {
                        mutableStateOf(true)
                    };
                    val onTimeout = { isLoading.value = false }
                    LaunchedEffect(onTimeout) {
                        //Fetch data Select film screen
                        delay(500)
                        onTimeout()
                    }
                    if (isLoading.value) {
                        WelcomeScreen()
                    } else PaymentSuccessScreen(mainNavHostController = navHostController)
                }

            }
        }
    }

}

@Composable
fun MainScreens(mainNavHostController:CineSmartNavController){
    val navController = rememberCineSmartNavController()
    Scaffold(
        bottomBar = {
            MainBottomBar(navController = navController.navController)
        }
    ) {innerPadding->
        NavHost(navController = navController.navController, startDestination = Screens.SelectFilmScreen.route, modifier = Modifier.padding(innerPadding)){
            composable(route = Screens.SelectFilmScreen.route){
                val isLoading = remember {
                    mutableStateOf(true)
                };
                val onTimeout = { isLoading.value = false }
                LaunchedEffect(onTimeout) {
                    //Fetch data Select film screen
                    delay(500)
                    onTimeout()
                }
                if (isLoading.value) {
                    Box(modifier = Modifier
                        .fillMaxSize()
                        .background(LocalAppColor.current.backgroundColorDarkBody), contentAlignment = Alignment.Center){

                        CircleLoader(isVisible = isLoading.value, color = LocalAppColor.current.textColorOrange, modifier = Modifier.size(50.dp))
                    }
                } else SelectFilmScreen(mainNavHostController = mainNavHostController)
            }
            composable(route = Screens.UserInfoScreen.route){
                val isLoading = remember {
                    mutableStateOf(true)
                };
                val onTimeout = { isLoading.value = false }
                LaunchedEffect(onTimeout) {
                    //Fetch data Select film screen
                    delay(500)
                    onTimeout()
                }
                if (isLoading.value) {
                    Box(modifier = Modifier
                        .fillMaxSize()
                        .background(LocalAppColor.current.backgroundColorDarkBody), contentAlignment = Alignment.Center){

                        CircleLoader(isVisible = isLoading.value, color = LocalAppColor.current.textColorOrange, modifier = Modifier.size(50.dp))
                    }
                } else ProfileScreen(mainNavHostController = mainNavHostController)
            }
            composable(route = Screens.SelectTheaterScreen.route){
                val isLoading = remember {
                    mutableStateOf(true)
                };
                val onTimeout = { isLoading.value = false }
                LaunchedEffect(onTimeout) {
                    //Fetch data Select film screen
                    delay(500)
                    onTimeout()
                }
                if (isLoading.value) {
                    Box(modifier = Modifier
                        .fillMaxSize()
                        .background(LocalAppColor.current.backgroundColorDarkBody), contentAlignment = Alignment.Center){

                        CircleLoader(isVisible = isLoading.value, color = LocalAppColor.current.textColorOrange, modifier = Modifier.size(50.dp))
                    }
                } else SelectTheaterScreen(mainNavHostController = mainNavHostController)
            }

        }
    }
}
@Composable
fun LoginFragment(mainNavHostController: CineSmartNavController){
    val navController = rememberCineSmartNavController()
    NavHost(startDestination = Screens.LoginScreen.route, navController = navController.navController){
        composable(route = Screens.LoginScreen.route){
            LoginScreen(mainNavHostController = mainNavHostController, navController = navController)
        }
        composable(route = Screens.RegisterScreen.route){
            RegisterScreen(mainNavHostController = mainNavHostController, navController =navController)
        }
    }
}