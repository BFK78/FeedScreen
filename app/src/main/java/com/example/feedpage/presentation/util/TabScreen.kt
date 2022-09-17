package com.example.feedpage.presentation.util

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.example.feedpage.presentation.bazaar.BazaarScreen
import com.example.feedpage.presentation.charcha.CharchaScreen
import com.example.feedpage.presentation.profile.ProfileScreen

typealias ComposableFun = @Composable (NavController) -> Unit

sealed class TabScreen(val title: String, val screen: ComposableFun) {

    object Charcha: TabScreen(title = "charcha", screen = {CharchaScreen(navHostController = it)})
    object Bazaar: TabScreen(title = "bazaar", screen = { BazaarScreen() })
    object Profile: TabScreen(title = "profile", screen = { ProfileScreen() })

}
