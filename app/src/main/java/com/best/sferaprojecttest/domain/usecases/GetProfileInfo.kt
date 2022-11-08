package com.best.sferaprojecttest.domain.usecases

import com.best.sferaprojecttest.domain.models.ProfileInfo
import com.best.sferaprojecttest.domain.repository.ProfileRepository
import com.best.sferaprojecttest.domain.util.Resource
import kotlinx.coroutines.flow.Flow

class GetProfileInfo(
    private val repository: ProfileRepository
) {
    operator fun invoke(): Flow<Resource<ProfileInfo>> {
        return repository.fetchProfileInfo()
    }
}