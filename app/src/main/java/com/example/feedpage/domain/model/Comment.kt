package com.example.feedpage.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Comment(
    val posterInfo: PosterInfo,
    val comment: String,
): Parcelable
