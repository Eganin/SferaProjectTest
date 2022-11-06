package com.best.sferaprojecttest.domain.usecases

import com.best.sferaprojecttest.domain.models.PeopleInfo
import com.best.sferaprojecttest.domain.repository.ProfileRepository
import kotlinx.coroutines.flow.Flow

class GetPeopleInfo(
    private val repository: ProfileRepository
) {
    operator fun invoke(): Flow<Triple<List<PeopleInfo>, List<PeopleInfo>, List<PeopleInfo>>> {
        return repository.fetchPeoplesInfo()
    }
}