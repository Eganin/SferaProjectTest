package com.best.sferaprojecttest.domain.repository

import com.best.sferaprojecttest.domain.models.ImageForList
import com.best.sferaprojecttest.domain.models.PeopleInfo
import com.best.sferaprojecttest.domain.models.ProfileInfo
import com.best.sferaprojecttest.domain.util.Resource
import kotlinx.coroutines.flow.Flow

interface ProfileRepository {
    fun fetchPeoplesInfo(): Flow<Resource<Triple<List<PeopleInfo>, List<PeopleInfo>, List<PeopleInfo>>>>
    fun fetchProfileInfo(): Flow<Resource<ProfileInfo>>
    fun fetchProfileImages():Flow<Resource<List<ImageForList>>>
    fun fetchMoments(): Flow<Resource<List<ImageForList>>>
    fun fetchChronicies():Flow<Resource<List<ImageForList>>>
}