package com.best.sferaprojecttest.domain.usecases

data class SferaUseCases(
    val getPeoplesInfo: GetPeopleInfo,
    val getProfileInfo: GetProfileInfo,
    val getProfileImages: GetProfileImages,
    val getMoments: GetMoments,
    val getChronicies: GetChronicies,
    val updatePeopleInfoAndGetPeoplesInfo: UpdatePeopleInfoAndGetPeoplesInfo,
    val getImageAndDescription: GetImageAndDescription
)
