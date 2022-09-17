package com.example.feedpage.presentation.feed

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.navigation.NavHostController
import com.example.feedpage.presentation.util.TabScreen
import com.google.accompanist.pager.*
import kotlinx.coroutines.launch

@OptIn(ExperimentalPagerApi::class)
@Composable
fun FeedScreen(
    navHostController: NavHostController
) {
    val tabs = listOf(
        TabScreen.Charcha,
        TabScreen.Bazaar,
        TabScreen.Profile
    )

    val pagerState = rememberPagerState()
    Scaffold() { padding ->
        Column(
            modifier = Modifier.padding(padding)
        ) {
            Tabs(tabs = tabs, pagerState = pagerState)
            TabsContent(tabs = tabs, pagerState = pagerState, navHostController = navHostController)
        }
    }

}

@OptIn(ExperimentalPagerApi::class)
@Composable
fun Tabs(tabs: List<TabScreen>, pagerState: PagerState) {

    val scope = rememberCoroutineScope()

    TabRow(
        selectedTabIndex = pagerState.currentPage,
        backgroundColor = Color.White,
        contentColor = Color.Black.copy(alpha = 0.7f),
        indicator = {
            TabRowDefaults.Indicator(
                Modifier.pagerTabIndicatorOffset(pagerState = pagerState, tabPositions = it),
                color = MaterialTheme.colors.primary
            )
        }
    ) {

        tabs.forEachIndexed { index, tabScreen ->
           Tab(
               selected = pagerState.currentPage == index,
               onClick = { scope.launch { pagerState.animateScrollToPage(index) } },
               text = { Text(
                   text = tabScreen.title,
                   color = if (pagerState.currentPage == index) MaterialTheme.colors.primary else Color.Black.copy(
                       alpha = 0.7f),
                   fontWeight = FontWeight.Bold
               ) },
           )
        }
    }
}

@OptIn(ExperimentalPagerApi::class)
@Composable
fun TabsContent(
    tabs: List<TabScreen>,
    pagerState: PagerState,
    navHostController: NavHostController
) {
    HorizontalPager(state = pagerState, count = tabs.size) { page ->
        tabs[page].screen(navHostController)
    }
}