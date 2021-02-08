package uk.me.mungorae.androidnews.api

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Article(
    val title: String,
    val description: String,
    val link: String,
): Parcelable