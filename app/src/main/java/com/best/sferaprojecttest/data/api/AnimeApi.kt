package com.best.sferaprojecttest.data.api

import com.best.sferaprojecttest.data.dto.AnimeResponse
import io.reactivex.rxjava3.core.Observable
import retrofit2.http.GET

interface AnimeApi {
    @GET("/random/?is_nsfw=false&full=false")
    fun getAnimeData(): Observable<AnimeResponse>
}