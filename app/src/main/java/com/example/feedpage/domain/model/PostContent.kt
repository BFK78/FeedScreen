package com.example.feedpage.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class PostContent(
    val text: String,
    val images: List<String>
): Parcelable
