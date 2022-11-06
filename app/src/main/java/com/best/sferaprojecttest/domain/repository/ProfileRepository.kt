package com.best.sferaprojecttest.domain.repository

import com.best.sferaprojecttest.domain.models.ImageForList
import com.best.sferaprojecttest.domain.models.PeopleInfo
import com.best.sferaprojecttest.domain.models.ProfileInfo
import kotlinx.coroutines.flow.Flow

interface ProfileRepository {
    fun fetchPeoplesInfo(): Flow<Triple<List<PeopleInfo>, List<PeopleInfo>, List<PeopleInfo>>>
    fun fetchProfileInfo(): Flow<ProfileInfo>
    fun fetchProfileImages():Flow<List<ImageForList>>
    fun fetchMoments(): Flow<List<ImageForList>>
    fun fetchChronicies():Flow<List<ImageForList>>
}