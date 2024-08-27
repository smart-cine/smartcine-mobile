package com.example.cinesmart.Screens


sealed class Screens(val route:String){
    object FilmFragment:Screens("film_fragment")
    object LoginFragment:Screens("login_fragment")
    object SelectFilmScreen:Screens("select_film")
    object FilmInfoScreen:Screens("film_info")
    object SelectFilmPerTheaterScreen:Screens("select_film_per_theater")
    object SelectTheaterScreen:Screens("select_theater")
    object UserInfoScreen:Screens("user_info")
    object PickSeatScreen:Screens("pick_seat")
    object PaymentScreen:Screens("payment")
    object PaymentSuccessScreen:Screens("payment_success")
    object AllCommentScreen:Screens("all_comment")
    object LoginScreen:Screens("login")
    object RegisterScreen:Screens("register")

}