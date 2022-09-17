package com.example.feedpage.presentation.util

import android.os.Bundle
import androidx.navigation.NavType
import com.example.feedpage.domain.model.Post
import com.google.gson.Gson

class CustomNavType() : NavType<Post>(isNullableAllowed = false) {
    override fun get(bundle: Bundle, key: String): Post? {
        return bundle.getParcelable(key)
    }

    override fun parseValue(value: String): Post {
        return Gson().fromJson(value, Post::class.java)
    }

    override fun put(bundle: Bundle, key: String, value: Post) {
        bundle.putParcelable(key, value)
    }
}