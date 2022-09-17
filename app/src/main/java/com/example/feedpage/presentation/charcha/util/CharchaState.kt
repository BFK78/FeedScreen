package com.example.feedpage.presentation.charcha.util

import com.example.feedpage.domain.model.Post

data class CharchaState(
    val isLoading: Boolean = false,
    val items: List<Post> = emptyList(),
    val error: String? = null,
    val endReached: Boolean = false,
    val page: Int = 0
)
