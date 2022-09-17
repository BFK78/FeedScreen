package com.example.feedpage.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.feedpage.presentation.charcha.components.FeedProfile
import com.example.feedpage.presentation.ui.theme.FeedPageTheme
import com.example.feedpage.R
import com.example.feedpage.domain.model.Post
import com.example.feedpage.presentation.charcha.actionscreen.CommentScreen
import com.example.feedpage.presentation.feed.FeedScreen
import com.example.feedpage.presentation.util.CustomNavType
import com.example.feedpage.presentation.util.Screens
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FeedPageTheme {
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                ) {
                    val navHostController = rememberNavController()
                    ApplicationNavigation(navHostController = navHostController)
                }
            }
        }
    }
}

@Composable
fun ApplicationNavigation(navHostController: NavHostController) {

    NavHost(
        navController = navHostController,
        startDestination = Screens.HomeScreen.route
    ) {

        composable(route = Screens.HomeScreen.route) {
            FeedScreen(navHostController = navHostController)
        }

        composable(route = Screens.CommentScreen.route + "/{model}", arguments = listOf(
            navArgument(name = "model") {
                type = CustomNavType()
            }
        )) {
            val model = it.arguments?.getParcelable<Post>("model")
            CommentScreen(navHostController = navHostController, post = model)
        }

    }

}
