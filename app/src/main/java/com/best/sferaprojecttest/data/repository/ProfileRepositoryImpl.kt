package com.best.sferaprojecttest.data.repository

import com.best.sferaprojecttest.data.util.DefaultDispatchers
import com.best.sferaprojecttest.domain.models.ImageForList
import com.best.sferaprojecttest.domain.models.PeopleInfo
import com.best.sferaprojecttest.domain.models.ProfileInfo
import com.best.sferaprojecttest.domain.repository.ProfileRepository
import com.best.sferaprojecttest.domain.util.Resource
import io.github.serpro69.kfaker.Faker
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class ProfileRepositoryImpl @Inject constructor() : ProfileRepository {

    private val dispatchers: DefaultDispatchers = DefaultDispatchers.Base()

    override fun fetchPeoplesInfo(): Flow<Resource<Triple<List<PeopleInfo>, List<PeopleInfo>, List<PeopleInfo>>>> {
        return flow {
            bodyForDataLoading(dispatchers) {
                generateList()
            }
        }
    }

    override fun fetchProfileInfo(): Flow<Resource<ProfileInfo>> {
        return flow {
            bodyForDataLoading(dispatchers) {
                ProfileInfo(
                    avatarLink = "https://i.pinimg.com/736x/7e/ce/c4/7ecec434137d1fcbe023db38e06c1260.jpg",
                    rating = 5.0,
                    id = "ID 123 456 789",
                    nickName = "Eren Jager",
                    languages = "English, Japanese",
                    geolocations = "Paradise"
                )
            }
        }
    }

    override fun fetchProfileImages(): Flow<Resource<List<ImageForList>>> {
        return flow {
            bodyForDataLoading(dispatchers) {
                listOf(
                    ImageForList(link = "https://i.pinimg.com/736x/7e/ce/c4/7ecec434137d1fcbe023db38e06c1260.jpg"),
                    ImageForList(link = "https://cloudfront-us-east-1.images.arcpublishing.com/gruporepublica/3SJFG4PNVZCTPEFICIMBX3GBNI.jpg"),
                    ImageForList(link = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRAOx2RPl8fc_NYxNNpuFM26XqTphDKOrVVzw&usqp=CAU"),
                    ImageForList(link = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS_SBzlRLLwDLMkPqQpgiwwAXru6zTv9TgllJBx1YtV3K7Em9AZ1maJ9PbmLKxwZxEcTWw&usqp=CAU"),
                )
            }
        }
    }

    override fun fetchMoments(): Flow<Resource<List<ImageForList>>> {
        return flow {
            bodyForDataLoading(dispatchers) {
                listOf(
                    ImageForList(link = "https://i.pinimg.com/736x/7e/ce/c4/7ecec434137d1fcbe023db38e06c1260.jpg"),
                    ImageForList(link = "https://cloudfront-us-east-1.images.arcpublishing.com/gruporepublica/3SJFG4PNVZCTPEFICIMBX3GBNI.jpg"),
                    ImageForList(link = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRAOx2RPl8fc_NYxNNpuFM26XqTphDKOrVVzw&usqp=CAU"),
                    ImageForList(link = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRAOx2RPl8fc_NYxNNpuFM26XqTphDKOrVVzw&usqp=CAU"),
                    ImageForList(link = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS_SBzlRLLwDLMkPqQpgiwwAXru6zTv9TgllJBx1YtV3K7Em9AZ1maJ9PbmLKxwZxEcTWw&usqp=CAU"),
                )
            }
        }
    }

    override fun fetchChronicies(): Flow<Resource<List<ImageForList>>> {
        return flow {
            bodyForDataLoading(dispatchers) {
                listOf(
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
                )
            }
        }
    }

    private fun generateList(): Triple<List<PeopleInfo>, List<PeopleInfo>, List<PeopleInfo>> {
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

        return Triple(
            first = subscribers,
            second = subscriptions,
            third = mutually
        )
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