package com.best.sferaprojecttest.presentation.fragments.people.viewpager

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.best.sferaprojecttest.presentation.fragments.people.PeopleFragment
import com.best.sferaprojecttest.presentation.fragments.people.PeopleViewModel
import com.best.sferaprojecttest.presentation.fragments.people.adapters.PeopleAdapter

class ViewPagerAdapter(
    private val peopleAdapterOne: PeopleAdapter,
    private val peopleAdapterTwo: PeopleAdapter,
    private val peopleAdapterThree: PeopleAdapter,
    private val viewModel: PeopleViewModel,
    fragment: Fragment
) :
    FragmentStateAdapter(fragment) {
    override fun getItemCount() = VIEW_PAGER_SIZE

    override fun createFragment(position: Int): Fragment {

        return when (position) {
            0 -> PeopleFragment(
                peopleAdapter = peopleAdapterOne,
                type = TypePeopleList.SUBSCRIBERS,
                viewModel = viewModel
            )
            1 -> PeopleFragment(
                peopleAdapter =peopleAdapterTwo,
                type = TypePeopleList.SUBSCRIPTIONS,
                viewModel = viewModel
            )
            else -> PeopleFragment(
                peopleAdapter =peopleAdapterThree,
                type = TypePeopleList.MUTUALLY,
                viewModel = viewModel
            )
        }
    }

    private companion object {
        const val VIEW_PAGER_SIZE = 3
    }
}

enum class TypePeopleList {
    SUBSCRIBERS,
    SUBSCRIPTIONS,
    MUTUALLY
}