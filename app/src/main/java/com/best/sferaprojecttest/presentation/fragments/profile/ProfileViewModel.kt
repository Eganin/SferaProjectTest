package com.best.sferaprojecttest.presentation.fragments.profile

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.best.sferaprojecttest.domain.models.ImageForList
import com.best.sferaprojecttest.domain.models.ProfileInfo
import com.best.sferaprojecttest.domain.usecases.SferaUseCases
import com.best.sferaprojecttest.domain.util.Resource
import com.best.sferaprojecttest.presentation.fragments.UiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.toCollection
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(
    private val useCases: SferaUseCases
) : ViewModel() {

    private val _uiState = MutableLiveData<UiState>()
    val uiState: LiveData<UiState> = _uiState

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

            useCases.getChronicies().collect { result ->
                wrapperForHandlerResource(result = result) {
                    _imagesForChronicies.postValue(it)
                }
            }

            useCases.getProfileImages().collect { result ->
                wrapperForHandlerResource(result = result) {
                    _imagesForProfile.postValue(it)
                }
            }

            useCases.getProfileInfo().collect { result ->
                wrapperForHandlerResource(result = result) {
                    _profileInfo.postValue(it)
                }
            }

            useCases.getMoments().collect { result ->
                wrapperForHandlerResource(result = result) {
                    _imagesForMoments.postValue(it)
                }
            }
        }
    }

    private fun <T> wrapperForHandlerResource(
        result: Resource<T>,
        onStateChangeSuccess: (T) -> Unit
    ) {
        when (result) {
            is Resource.Success -> {
                result.data?.let {
                    onStateChangeSuccess(it)
                }
            }

            is Resource.Error -> {
                result.message?.let {
                    _uiState.postValue(UiState.ShowError(message = it))
                }
            }

            is Resource.Loading -> {
                if (result.isLoading){
                    _uiState.postValue(UiState.ShowLoading)
                }else{
                    _uiState.postValue(UiState.HideLoading)
                }
            }
        }
    }
}