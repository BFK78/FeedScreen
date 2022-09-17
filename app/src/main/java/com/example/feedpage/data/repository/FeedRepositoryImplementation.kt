package com.example.feedpage.data.repository

import android.util.Log
import com.example.feedpage.data.remote.PostApi
import com.example.feedpage.domain.model.Post
import com.example.feedpage.domain.repository.FeedRepository
import kotlinx.coroutines.delay

class FeedRepositoryImplementation(
    private val api: PostApi
): FeedRepository {

    private var list: List<Post> = emptyList()

    override suspend fun getAllPosts(): List<Post> {
        list = api.getAllPosts()
        Log.i("basim above", list.toString())
        return list
    }

    override suspend fun getItems(page: Int, pageSize: Int): Result<List<Post>> {
        if (list.isEmpty()) {
            getAllPosts()
        }
        delay(1000)
        val startingIndex = page + pageSize
        return if (
            startingIndex + pageSize <= list.size
        )  {
            Result.success(list.slice(startingIndex until startingIndex + pageSize))
        } else {
            Result.success(emptyList())
        }
    }


}