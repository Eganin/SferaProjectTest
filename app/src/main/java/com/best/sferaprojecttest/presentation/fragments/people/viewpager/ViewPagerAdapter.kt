package com.best.sferaprojecttest.presentation.fragments.people.viewpager

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.best.sferaprojecttest.presentation.fragments.people.PeopleFragment
import com.best.sferaprojecttest.presentation.fragments.people.PeopleViewModel
import com.best.sferaprojecttest.presentation.fragments.people.adapters.PeopleAdapter
import com.bumptech.glide.RequestManager

class ViewPagerAdapter(
    private val glide: RequestManager,
    private val viewModel: PeopleViewModel,
    fragment: Fragment
) : FragmentStateAdapter(fragment) {
    override fun getItemCount() = VIEW_PAGER_SIZE

    override fun createFragment(position: Int): Fragment {

        return when (position) {
            0 -> PeopleFragment(
                glide=glide,
                type = TypePeopleList.SUBSCRIBERS,
                viewModel = viewModel
            )
            1 -> PeopleFragment(
                glide=glide,
                type = TypePeopleList.SUBSCRIPTIONS,
                viewModel = viewModel
            )
            else -> PeopleFragment(
                glide=glide,
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