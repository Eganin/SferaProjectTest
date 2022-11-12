package com.best.sferaprojecttest.data.mappers

import com.best.sferaprojecttest.data.dto.AnimeResponse
import com.best.sferaprojecttest.domain.models.AnimeInfo

fun AnimeResponse.toAnimeInfo(): AnimeInfo {
    val image = images[0]
    val tag = image.tags.last()
    return AnimeInfo(
        imageLink = image.url ?: "",
        description = "Favourites " + (image.favourites
            ?: 0) + "\n" + "Source " + image.source + "\n" + "Is nsfw " + image.isNsfw + "\n" + tag.description
    )
}