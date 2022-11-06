package com.best.sferaprojecttest.presentation.fragments.profile

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.best.sferaprojecttest.domain.models.ImageForList
import com.best.sferaprojecttest.domain.models.ProfileInfo
import com.best.sferaprojecttest.domain.usecases.SferaUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(
    private val useCases: SferaUseCases
) : ViewModel() {

    private val _profileInfo = MutableLiveData<ProfileInfo>()
    val profileInfo: LiveData<ProfileInfo> = _profileInfo

    private val _imagesForProfile = MutableLiveData<List<ImageForList>>()
    val imagesForProfile: LiveData<List<ImageForList>> = _imagesForProfile

    private val _imagesForMoments = MutableLiveData<List<ImageForList>>()
    val imagesForMoments: LiveData<List<ImageForList>> = _imagesForMoments

    private val _imagesForChronicies = MutableLiveData<List<ImageForList>>()
    val imagesForChronicies: LiveData<List<ImageForList>> = _imagesForChronicies

    fun init() {
        viewModelScope.launch {
            useCases.getProfileInfo().collect {
                _profileInfo.postValue(it)
            }

            useCases.getProfileImages().collect {
                _imagesForProfile.postValue(it)
            }

            useCases.getMoments().collect {
                _imagesForMoments.postValue(it)
            }

            useCases.getChronicies().collect {
                _imagesForChronicies.postValue(it)
            }

        }
    }
}