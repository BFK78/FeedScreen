package com.example.feedpage.presentation.charcha

import android.net.Uri
import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import com.example.feedpage.R
import com.example.feedpage.domain.model.Post
import com.example.feedpage.presentation.charcha.components.FeedAction
import com.example.feedpage.presentation.charcha.components.FeedContent
import com.example.feedpage.presentation.charcha.components.FeedProfile
import com.example.feedpage.presentation.charcha.viewmodel.CharchaViewModel
import com.example.feedpage.presentation.util.Screens
import com.google.gson.Gson

@OptIn(ExperimentalCoilApi::class)
@Composable
fun CharchaScreen(
    viewModel: CharchaViewModel = hiltViewModel(),
    navHostController: NavController
) {

    val state = viewModel.state

    val like = remember {
        mutableStateOf(false)
    }
    val post = remember {
        mutableStateOf<Post?>(null)
    }

    Column(
        modifier = Modifier
            .fillMaxSize(),
    ) {

        LazyColumn {
            items(state.items.size) { i ->

                val it = state.items[i]

                Log.i("basim",
                    "${i}  ${state.items.size - 1}  ${state.isLoading}  ${state.endReached}")

                if (i >= state.items.size - 1 && !state.endReached && !state.isLoading) {
                    Log.i("basim inside", "called")
                    viewModel.loadNextItems()
                }

                val imagePainter = rememberImagePainter(data = it.posterInfo.image) {
                    crossfade(600)
                    error(R.drawable.ic_launcher_background)
                }

                FeedProfile(
                    painter = imagePainter,
                    name = it.posterInfo.name,
                    lastOnline = "2",
                    postType = it.postType.status,
                )

                FeedContent(
                    text = it.postContent.text,
                    content = it.postContent.images,
                    modifier = Modifier
                        .padding(horizontal = 16.dp),
                )

                Spacer(modifier = Modifier.height(24.dp))

                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceAround,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    FeedAction(
                        icon = painterResource(id = R.drawable.ic_favourite),
                        value = it.likes.toString(),
                        text = "likes",
                        isSelected = like.value
                    ) {
                        like.value = !like.value
                    }

                    FeedAction(
                        icon = painterResource(id = R.drawable.ic_comments),
                        value = it.comments.size.toString(),
                        text = "comments"
                    ) {
                        post.value = it
                        val model = it
                        val json = Uri.encode(Gson().toJson(model))
                        Log.i("basim 342", Screens.CommentScreen.route + "/${json}")
                        navHostController.navigate(route = Screens.CommentScreen.route + "/${json}")
                    }

                    FeedAction(
                        icon = painterResource(id = R.drawable.ic_share),
                        value = "",
                        text = "share"
                    ) {

                    }

                }

                Spacer(modifier = Modifier.height(24.dp))

                Divider(
                    modifier = Modifier
                        .fillMaxWidth()
                )

            }
            item {
                if (state.isLoading) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp),
                        horizontalArrangement = Arrangement.Center
                    ) {
                        CircularProgressIndicator(color = MaterialTheme.colors.primary)
                    }
                }
            }
        }

    }
}


