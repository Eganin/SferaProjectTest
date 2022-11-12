package com.best.sferaprojecttest.domain.usecases

import com.best.sferaprojecttest.domain.models.PeopleInfo
import com.best.sferaprojecttest.domain.repository.ProfileRepository
import com.best.sferaprojecttest.domain.util.Resource
import kotlinx.coroutines.flow.Flow

class UpdatePeopleInfoAndGetPeoplesInfo(
    private val repository: ProfileRepository
) {
    operator fun invoke(peopleInfo: PeopleInfo): Flow<Resource<Triple<List<PeopleInfo>, List<PeopleInfo>, List<PeopleInfo>>>> {
        repository.updatePeopleInfo(peopleInfo = peopleInfo)
        return repository.fetchPeoplesInfo()
    }
}