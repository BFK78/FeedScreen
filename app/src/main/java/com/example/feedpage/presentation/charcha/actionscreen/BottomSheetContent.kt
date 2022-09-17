package com.example.feedpage.presentation.charcha.actionscreen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import com.example.feedpage.R
import com.example.feedpage.domain.model.Post
import com.example.feedpage.presentation.charcha.components.FeedAction
import com.example.feedpage.presentation.charcha.components.FeedContent
import com.example.feedpage.presentation.charcha.components.FeedProfile
import com.example.feedpage.presentation.profile.ProfileScreen

@OptIn(ExperimentalCoilApi::class)
@Composable
fun CommentScreen(
    navHostController: NavHostController,
    post: Post?
) {

    val imagePainter = rememberImagePainter(data = post?.posterInfo?.image) {
        crossfade(600)
    }

    val like = remember {
        mutableStateOf(false)
    }

    Scaffold(
        modifier = Modifier
            .fillMaxSize(),
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "Comments")
                },
                navigationIcon = {
                    IconButton(onClick = { navHostController.popBackStack() }) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = ""
                        )
                    }
                },
                backgroundColor = Color.White,
                elevation = 0.dp
            )
        }
    ) {

        Column(
            modifier = Modifier
                .padding(it)
        ) {

            if (post != null) {


                LazyColumn {

                    item {
                        FeedProfile(
                            painter = imagePainter,
                            name = post.posterInfo.name,
                            lastOnline = "2",
                            postType = post.postType.status
                        )


                        FeedContent(
                            text = post.postContent.text,
                            content = post.postContent.images,
                            modifier = Modifier.padding(horizontal = 16.dp)
                        )

                        Row(
                            modifier = Modifier
                                .padding(16.dp)
                                .fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {

                            Text(text = "${post.comments.size} comments")

                            Text(
                                text = "Recent",
                                color = MaterialTheme.colors.primary)

                        }
                    }
                    items(post.comments) { comment ->


                        FeedProfile(painter = imagePainter, name = post.posterInfo.name, lastOnline = "2", postType = post.postType.status)

                        Text(
                            text = comment.comment,
                            modifier = Modifier.padding(horizontal = 16.dp)
                        )

                        Spacer(modifier = Modifier.height(16.dp))

                        FeedAction(icon = painterResource(id = R.drawable.ic_favourite),
                            value = "",
                            text = "likes",
                            modifier = Modifier.padding(start = 16.dp),
                            isSelected = like.value) {
                            like.value = !like.value
                        }
                        
                        Spacer(modifier = Modifier.height(24.dp))

                        Divider(
                            modifier = Modifier
                                .fillMaxWidth()
                        )
                    }
                }

            }
        }
    }
}