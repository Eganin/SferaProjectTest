package com.best.sferaprojecttest.domain.usecases

import com.best.sferaprojecttest.domain.models.ImageForList
import com.best.sferaprojecttest.domain.repository.ProfileRepository
import kotlinx.coroutines.flow.Flow

class GetChronicies(
    private val repository: ProfileRepository
) {
    operator fun invoke(): Flow<List<ImageForList>> {
        return repository.fetchChronicies()
    }
}