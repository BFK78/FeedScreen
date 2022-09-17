package com.example.feedpage.data.remote

import com.example.feedpage.domain.model.Post
import retrofit2.http.GET
import retrofit2.http.Query

interface PostApi {

    @GET("templates/2wnpD-nqWHGd/data")
    suspend fun getAllPosts(
        @Query("access_token") accessToken: String = "98yg1j7bs5nwtbek1th2x3gvaz3jd35yurl1r7cs"
    ): List<Post>

}