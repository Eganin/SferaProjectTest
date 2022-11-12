package com.best.sferaprojecttest.presentation.fragments.people

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.best.sferaprojecttest.domain.models.PeopleInfo
import com.best.sferaprojecttest.domain.usecases.SferaUseCases
import com.best.sferaprojecttest.domain.util.Resource
import com.best.sferaprojecttest.presentation.fragments.UiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PeopleViewModel @Inject constructor(
    private val sferaUseCases: SferaUseCases
) : ViewModel() {

    private var peoplesList: Triple<List<PeopleInfo>, List<PeopleInfo>, List<PeopleInfo>>?= null

    private val _uiState = MutableLiveData<UiState>()
    val uiState: LiveData<UiState> = _uiState

    private val _subscribersInfo = MutableLiveData<List<PeopleInfo>>()
    val subscribersInfo: LiveData<List<PeopleInfo>> = _subscribersInfo

    private val _subscriptionsInfo = MutableLiveData<List<PeopleInfo>>()
    val subscriptionsInfo: LiveData<List<PeopleInfo>> = _subscriptionsInfo

    private val _mutuallyInfo = MutableLiveData<List<PeopleInfo>>()
    val mutuallyInfo: LiveData<List<PeopleInfo>> = _mutuallyInfo

    private var currentViewPagerPosition = 0

    fun changePositionForViewPager(position: Int) {
        currentViewPagerPosition = position
    }

    fun updateList(peopleInfo: PeopleInfo) {
        viewModelScope.launch {
            sferaUseCases.updatePeopleInfoAndGetPeoplesInfo(peopleInfo = peopleInfo)
                .collect { result ->
                    wrapperForHandlerResource(result = result) {
                        peoplesList = it
                    }
                }
        }
    }

    fun filterList(filterNickName: String) {
        viewModelScope.launch {
            when (currentViewPagerPosition) {
                0 -> {
                    _subscribersInfo.postValue(peoplesList?.first?.filter {
                        it.title.lowercase().contains(
                            filterNickName.lowercase()
                        )
                    })
                }
                1 -> {
                    _subscriptionsInfo.postValue(peoplesList?.second?.filter {
                        it.title.lowercase().contains(
                            filterNickName.lowercase()
                        )
                    })
                }
                else -> {
                    _mutuallyInfo.postValue(peoplesList?.third?.filter {
                        it.title.lowercase().contains(
                            filterNickName.lowercase()
                        )
                    })
                }
            }
        }
    }

    fun init() {
        viewModelScope.launch {
            sferaUseCases.getPeoplesInfo().collect { result ->
                wrapperForHandlerResource(result = result) {
                    peoplesList = it
                }
            }
            _subscribersInfo.postValue(peoplesList?.first ?: emptyList())
            _subscriptionsInfo.postValue(peoplesList?.second ?: emptyList())
            _mutuallyInfo.postValue(peoplesList?.third ?: emptyList())

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
                if (result.isLoading) {
                    _uiState.postValue(UiState.ShowLoading)
                } else {
                    _uiState.postValue(UiState.HideLoading)
                }
            }
        }
    }
}