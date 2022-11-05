package com.best.sferaprojecttest.presentation.fragments.people.viewpager

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.best.sferaprojecttest.presentation.fragments.people.PeopleFragment
import com.best.sferaprojecttest.presentation.fragments.people.adapters.PeopleAdapter

class ViewPagerAdapter(private val peopleAdapter: PeopleAdapter, fragment: Fragment) :
    FragmentStateAdapter(fragment) {
    override fun getItemCount() = VIEW_PAGER_SIZE

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> PeopleFragment(peopleAdapter)
            1 -> PeopleFragment(peopleAdapter)
            else -> PeopleFragment(peopleAdapter)
        }
    }

    private companion object {
        const val VIEW_PAGER_SIZE = 3
    }
}