package com.best.sferaprojecttest.data.repository

import android.util.Log
import com.best.sferaprojecttest.data.api.AnimeApi
import com.best.sferaprojecttest.data.mappers.toAnimeInfo
import com.best.sferaprojecttest.domain.models.AnimeInfo
import com.best.sferaprojecttest.domain.repository.ImageRepository
import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class ImageRepositoryImpl @Inject constructor(
    private val api: AnimeApi
) : ImageRepository {
    override fun getImageAndDescription(): Single<AnimeInfo> {
        return api.getAnimeData()
            .subscribeOn(Schedulers.io())
            .map {
                Log.d("EEE", it.toString())
                Log.d("EEE", it.toAnimeInfo().toString())
                it.toAnimeInfo()
            }
    }
}