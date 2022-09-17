package com.example.feedpage.domain.repository

import com.example.feedpage.domain.model.Post

interface FeedRepository {

    suspend fun getAllPosts(): List<Post>

    suspend fun getItems(page: Int, pageSize: Int): Result<List<Post>>

}