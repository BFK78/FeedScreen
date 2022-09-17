package com.example.feedpage.domain.model

import android.os.Parcelable
import com.example.feedpage.domain.util.PostType
import kotlinx.parcelize.Parcelize
import kotlinx.parcelize.RawValue

@Parcelize
data class Post(
    val id: String,
    val posterInfo: PosterInfo,
    val postType: PostType,
    val likes: Int,
    val comments: List<Comment>,
    val postContent: PostContent
): Parcelable