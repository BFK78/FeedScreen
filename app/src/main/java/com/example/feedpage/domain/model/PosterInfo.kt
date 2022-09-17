package com.example.feedpage.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class  PosterInfo(
    val name: String,
    val image: String
): Parcelable
