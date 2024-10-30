package com.example.cinesmart.Navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.lifecycle.Lifecycle
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.cinesmart.Screens.Screens

@Composable
fun rememberCineSmartNavController(
    navController: NavHostController = rememberNavController()
):CineSmartNavController = remember(navController){
    CineSmartNavController(navController = navController)
}


class CineSmartNavController(
    val navController:NavHostController
) {
    fun navigateBack(){
        navController.navigateUp()

    }
    fun navigateToHome(){
        navController.navigate(route = Screens.FilmFragment.route){
            launchSingleTop = true
            restoreState = true

        }
    }
    fun navvigateToFilmDetail(from:NavBackStackEntry){
        if (from.lifeCycleIsResumed()){
            navController.navigate(
                Screens.FilmInfoScreen.route
            )
        }
    }

}

private fun NavBackStackEntry.lifeCycleIsResumed() = this.lifecycle.currentState == Lifecycle.State.RESUMED