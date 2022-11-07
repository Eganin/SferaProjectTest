package com.best.sferaprojecttest.domain.usecases

import com.best.sferaprojecttest.domain.models.ImageForList
import com.best.sferaprojecttest.domain.repository.ProfileRepository
import com.best.sferaprojecttest.domain.util.Resource
import kotlinx.coroutines.flow.Flow

class GetProfileImages(
    private val repository: ProfileRepository
) {

    operator fun invoke(): Flow<Resource<List<ImageForList>>> {
        return repository.fetchProfileImages()
    }
}