package com.example.feedpage.domain.pagination

interface Paginator<Key, Item> {

    suspend fun loadNextItems()

    fun reset()

}