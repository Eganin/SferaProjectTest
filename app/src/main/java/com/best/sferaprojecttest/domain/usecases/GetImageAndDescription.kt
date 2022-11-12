package com.best.sferaprojecttest.domain.usecases

import com.best.sferaprojecttest.domain.models.AnimeInfo
import com.best.sferaprojecttest.domain.repository.ImageRepository
import io.reactivex.Observable

class GetImageAndDescription(
    private val repository: ImageRepository
) {

    operator fun invoke(): Observable<AnimeInfo> {
        return repository.getImageAndDescription()
    }
}