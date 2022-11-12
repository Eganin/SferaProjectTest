package com.best.sferaprojecttest.domain.repository

import com.best.sferaprojecttest.domain.models.AnimeInfo
import io.reactivex.Observable
import io.reactivex.Single

interface ImageRepository {
    fun getImageAndDescription(): Single<AnimeInfo>
}