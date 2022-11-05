package com.best.sferaprojecttest.presentation.fragments.people

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.best.sferaprojecttest.databinding.PeopleFragmentBinding
import com.best.sferaprojecttest.domain.models.PeopleInfo
import com.best.sferaprojecttest.presentation.fragments.people.adapters.PeopleAdapter
import io.github.serpro69.kfaker.Faker

class PeopleFragment(
    private val peopleAdapter: PeopleAdapter
) : Fragment() {

    private var _binding: PeopleFragmentBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = PeopleFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        val faker = Faker()
        val newList = (0..40).map { index ->
            PeopleInfo(
                id = index,
                title = faker.name.name(),
                imageLink = getLink(id = index),
                action = getAction(id = (1..2).random())
            )
        }
        binding.peoplesRv.adapter = peopleAdapter
        peopleAdapter.submitList(newList)
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