package com.best.sferaprojecttest.presentation.fragments.people

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.best.sferaprojecttest.domain.models.PeopleInfo
import dagger.hilt.android.lifecycle.HiltViewModel
import io.github.serpro69.kfaker.Faker
import javax.inject.Inject

@HiltViewModel
class PeopleViewModel @Inject constructor() : ViewModel() {

    private val _subscribersInfo = MutableLiveData<List<PeopleInfo>>()
    val subscribesInfo: LiveData<List<PeopleInfo>> = _subscribersInfo

    private val _subscriptionsInfo = MutableLiveData<List<PeopleInfo>>()
    val subscriptionsInfo: LiveData<List<PeopleInfo>> = _subscriptionsInfo

    private val _mutuallyInfo = MutableLiveData<List<PeopleInfo>>()
    val mutuallyInfo: LiveData<List<PeopleInfo>> = _mutuallyInfo

    fun init() {
        val faker = Faker()
        val subscriptions = mutableListOf<PeopleInfo>()
        val subscribers = mutableListOf<PeopleInfo>()
        val mutually = mutableListOf<PeopleInfo>()
        (0..40).map { index ->
            when (index) {
                in 0..12 -> subscribers.add(
                    PeopleInfo(
                        id = index,
                        title = faker.name.name(),
                        imageLink = getLink(id = index),
                        action = getAction(id = (1..2).random())
                    )
                )
                in 13..26 -> subscriptions.add(
                    PeopleInfo(
                        id = index,
                        title = faker.name.name(),
                        imageLink = getLink(id = index),
                        action = PeopleInfo.PeopleAction.UNSUBSCRIBE
                    )
                )
                else -> mutually.add(
                    PeopleInfo(
                        id = index,
                        title = faker.name.name(),
                        imageLink = getLink(id = index),
                        action = PeopleInfo.PeopleAction.UNSUBSCRIBE
                    )
                )
            }
        }

        _subscriptionsInfo.postValue(subscriptions)
        _subscribersInfo.postValue(subscribers)
        _mutuallyInfo.postValue(mutually)
    }

    private fun getAction(id: Int) = when (id) {
        1 -> PeopleInfo.PeopleAction.SUBSCRIBE
        else -> PeopleInfo.PeopleAction.UNSUBSCRIBE
    }

    private fun getLink(id: Int) = when {
        id % 3 == 0 -> "https://static.wikia.nocookie.net/shingekinokyojin/images/3/3d/Sasha_Blouse_character_image.png/revision/latest?cb=20180215193834"
        id % 5 == 0 -> "https://static.wikia.nocookie.net/shingekinokyojin/images/1/18/Erwin_Smith_character_image.png/revision/latest/scale-to-width-down/350?cb=20190514212751"
        id % 7 == 0 -> "https://static.wikia.nocookie.net/shingekinokyojin/images/9/91/Petra_Ral_character_image.png/revision/latest/scale-to-width-down/350?cb=20190824104211"
        id % 11 == 0 -> "https://static.wikia.nocookie.net/shingekinokyojin/images/7/7b/Porco_Galliard_character_image.png/revision/latest/scale-to-width-down/350?cb=20190410154154"
        id % 13 == 0 -> "https://static.wikia.nocookie.net/shingekinokyojin/images/0/02/Bertolt_Hoover_character_image.png/revision/latest/scale-to-width-down/350?cb=20190717190848"
        id % 17 == 0 -> "https://static.wikia.nocookie.net/shingekinokyojin/images/9/9f/Historia_Reiss_character_image.png/revision/latest/scale-to-width-down/350?cb=20210411172422"
        id % 19 == 0 -> "https://static.wikia.nocookie.net/shingekinokyojin/images/f/f7/Mikasa_Ackerman_character_image.png/revision/latest/scale-to-width-down/350?cb=20210410131531"
        id % 23 == 0 -> "https://static.wikia.nocookie.net/shingekinokyojin/images/0/0f/Reiner_Braun_character_image.png/revision/latest/scale-to-width-down/350?cb=20190710044204"
        id % 29 == 0 -> "https://static.wikia.nocookie.net/shingekinokyojin/images/6/69/Eren_Yeager_character_image.png/revision/latest/scale-to-width-down/350?cb=20200910221354"
        else -> "https://static.wikia.nocookie.net/shingekinokyojin/images/9/94/Levi_Ackerman_character_image.png/revision/latest?cb=20210410135001"
    }
}