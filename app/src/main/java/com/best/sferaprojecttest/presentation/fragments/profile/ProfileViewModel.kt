package com.best.sferaprojecttest.presentation.fragments.profile

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.best.sferaprojecttest.domain.models.ImageForList
import com.best.sferaprojecttest.domain.models.ProfileInfo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(

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
            _profileInfo.postValue(
                ProfileInfo(
                    avatarLink = "https://i.pinimg.com/736x/7e/ce/c4/7ecec434137d1fcbe023db38e06c1260.jpg",
                    rating = 5.0,
                    id = "ID 123 456 789",
                    nickName = "Eren Jager",
                    languages = "English, Japanese",
                    geolocations = "Paradise"
                )
            )

            _imagesForProfile.postValue(
                listOf(
                    ImageForList(link = "https://i.pinimg.com/736x/7e/ce/c4/7ecec434137d1fcbe023db38e06c1260.jpg"),
                    ImageForList(link = "https://cloudfront-us-east-1.images.arcpublishing.com/gruporepublica/3SJFG4PNVZCTPEFICIMBX3GBNI.jpg"),
                    ImageForList(link = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRAOx2RPl8fc_NYxNNpuFM26XqTphDKOrVVzw&usqp=CAU"),
                    ImageForList(link = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS_SBzlRLLwDLMkPqQpgiwwAXru6zTv9TgllJBx1YtV3K7Em9AZ1maJ9PbmLKxwZxEcTWw&usqp=CAU"),
                )
            )

            _imagesForMoments.postValue(
                listOf(
                    ImageForList(link = "https://i.pinimg.com/736x/7e/ce/c4/7ecec434137d1fcbe023db38e06c1260.jpg"),
                    ImageForList(link = "https://cloudfront-us-east-1.images.arcpublishing.com/gruporepublica/3SJFG4PNVZCTPEFICIMBX3GBNI.jpg"),
                    ImageForList(link = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRAOx2RPl8fc_NYxNNpuFM26XqTphDKOrVVzw&usqp=CAU"),
                    ImageForList(link = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRAOx2RPl8fc_NYxNNpuFM26XqTphDKOrVVzw&usqp=CAU"),
                    ImageForList(link = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS_SBzlRLLwDLMkPqQpgiwwAXru6zTv9TgllJBx1YtV3K7Em9AZ1maJ9PbmLKxwZxEcTWw&usqp=CAU"),
                )
            )

            _imagesForChronicies.postValue(listOf(
                ImageForList(link = "https://i.pinimg.com/736x/7e/ce/c4/7ecec434137d1fcbe023db38e06c1260.jpg"),
                ImageForList(link = "https://i.pinimg.com/736x/7e/ce/c4/7ecec434137d1fcbe023db38e06c1260.jpg"),
                ImageForList(link = "https://cloudfront-us-east-1.images.arcpublishing.com/gruporepublica/3SJFG4PNVZCTPEFICIMBX3GBNI.jpg"),
                ImageForList(link = "https://cloudfront-us-east-1.images.arcpublishing.com/gruporepublica/3SJFG4PNVZCTPEFICIMBX3GBNI.jpg"),
                ImageForList(link = "https://cloudfront-us-east-1.images.arcpublishing.com/gruporepublica/3SJFG4PNVZCTPEFICIMBX3GBNI.jpg"),
                ImageForList(link = "https://cloudfront-us-east-1.images.arcpublishing.com/gruporepublica/3SJFG4PNVZCTPEFICIMBX3GBNI.jpg"),
                ImageForList(link = "https://cloudfront-us-east-1.images.arcpublishing.com/gruporepublica/3SJFG4PNVZCTPEFICIMBX3GBNI.jpg"),
                ImageForList(link = "https://cloudfront-us-east-1.images.arcpublishing.com/gruporepublica/3SJFG4PNVZCTPEFICIMBX3GBNI.jpg"),
                ImageForList(link = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRAOx2RPl8fc_NYxNNpuFM26XqTphDKOrVVzw&usqp=CAU"),
                ImageForList(link = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRAOx2RPl8fc_NYxNNpuFM26XqTphDKOrVVzw&usqp=CAU"),
                ImageForList(link = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS_SBzlRLLwDLMkPqQpgiwwAXru6zTv9TgllJBx1YtV3K7Em9AZ1maJ9PbmLKxwZxEcTWw&usqp=CAU"),
            ))
        }
    }
}