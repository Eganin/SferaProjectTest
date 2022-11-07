package com.best.sferaprojecttest.presentation.fragments.people

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.best.sferaprojecttest.domain.models.PeopleInfo
import com.best.sferaprojecttest.domain.usecases.SferaUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PeopleViewModel @Inject constructor(
    private val sferaUseCases: SferaUseCases
) : ViewModel() {

    private lateinit var peoplesList: Triple<List<PeopleInfo>, List<PeopleInfo>, List<PeopleInfo>>

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

    fun updateList(item: PeopleInfo) {
        _subscriptionsInfo.postValue(peoplesList.second.toMutableList().also {
            it.remove(item)
        })
        _mutuallyInfo.postValue(peoplesList.third.toMutableList().also {
            it.remove(item)
        })
    }

    fun filterList(filterNickName: String) {
        viewModelScope.launch {
            when (currentViewPagerPosition) {
                0 -> {
                    _subscribersInfo.postValue(peoplesList.first.filter {
                        it.title.lowercase().contains(
                            filterNickName.lowercase()
                        )
                    })
                }
                1 -> {
                    _subscriptionsInfo.postValue(peoplesList.second.filter {
                        it.title.lowercase().contains(
                            filterNickName.lowercase()
                        )
                    })
                }
                else -> {
                    _mutuallyInfo.postValue(peoplesList.third.filter {
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
            sferaUseCases.getPeoplesInfo().collect {
                peoplesList = it
            }
            _subscribersInfo.postValue(peoplesList.first ?: emptyList())
            _subscriptionsInfo.postValue(peoplesList.second ?: emptyList())
            _mutuallyInfo.postValue(peoplesList.third ?: emptyList())

        }
    }
}