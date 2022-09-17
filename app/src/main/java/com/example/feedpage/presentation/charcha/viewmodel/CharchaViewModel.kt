package com.example.feedpage.presentation.charcha.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.feedpage.data.pagination.DefaultPaginator
import com.example.feedpage.domain.model.Post
import com.example.feedpage.domain.pagination.Paginator
import com.example.feedpage.domain.repository.FeedRepository
import com.example.feedpage.presentation.charcha.util.CharchaState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CharchaViewModel @Inject constructor(
    private val repository: FeedRepository
): ViewModel() {

    var state by mutableStateOf(CharchaState())
        private set

    private val paginator = DefaultPaginator(
        initialKey = state.page,
        onLoadUpdated = {
            state = state.copy(isLoading = it)
        },
        onRequest = {
            repository.getItems(it, 20)
        },
        getNextKey = {
            state.page + 1
        },
        onError = {
            state = state.copy(error = it?.localizedMessage)
        },
        onSuccess = {  items, newKey ->
            state = state.copy(
                items = state.items + items,
                page = newKey,
                endReached = items.isEmpty()
            )
        }
    )

    private fun getAllPosts() = viewModelScope.launch {
        repository.getAllPosts()
    }

    init {
        loadNextItems()
    }

    fun loadNextItems() {
        viewModelScope.launch {
            paginator.loadNextItems()
        }
    }

}