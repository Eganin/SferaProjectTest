package com.best.sferaprojecttest.domain.repository

import com.best.sferaprojecttest.domain.models.AnimeInfo
import io.reactivex.Observable

interface ImageRepository {
    fun getImageAndDescription(): Observable<AnimeInfo>
}