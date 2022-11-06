package com.best.sferaprojecttest.domain.usecases

import com.best.sferaprojecttest.domain.models.ProfileInfo
import com.best.sferaprojecttest.domain.repository.ProfileRepository
import kotlinx.coroutines.flow.Flow

class GetProfileInfo(
    private val repository: ProfileRepository
) {
    operator fun invoke(): Flow<ProfileInfo> {
        return repository.fetchProfileInfo()
    }
}