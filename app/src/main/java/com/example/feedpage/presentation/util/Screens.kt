package com.example.feedpage.presentation.util

sealed class Screens(val title: String, val route: String) {

    object HomeScreen: Screens(title = "Home Screen", route = "home_screen")

    object CommentScreen: Screens(title = "Comments", route = "comment_screen")

}
