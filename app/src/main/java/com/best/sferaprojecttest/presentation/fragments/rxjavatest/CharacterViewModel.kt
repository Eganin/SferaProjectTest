package com.best.sferaprojecttest.presentation.fragments.rxjavatest

import android.annotation.SuppressLint
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.best.sferaprojecttest.domain.models.AnimeInfo
import com.best.sferaprojecttest.domain.usecases.SferaUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import javax.inject.Inject

@HiltViewModel
class CharacterViewModel @Inject constructor(
    private val useCases: SferaUseCases
): ViewModel() {

    private val _info = MutableLiveData<AnimeInfo>()
    val info : LiveData<AnimeInfo> = _info

    @SuppressLint("CheckResult")
    fun init(){
        useCases.getImageAndDescription()
            .observeOn(AndroidSchedulers.mainThread())
            .map {
                _info.value=it
            }
            .subscribe()
    }
}