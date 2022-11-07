package com.best.sferaprojecttest.presentation.fragments

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.best.sferaprojecttest.presentation.fragments.people.adapters.PeopleAdapter
import com.best.sferaprojecttest.presentation.fragments.people.viewpager.PeopleViewPagerFragment
import com.best.sferaprojecttest.presentation.fragments.profile.ProfileFragment
import com.best.sferaprojecttest.presentation.fragments.profile.adapters.ChroniciesAdapter
import com.best.sferaprojecttest.presentation.fragments.profile.adapters.MomentsAdapter
import com.best.sferaprojecttest.presentation.fragments.profile.adapters.ProfileImagesAdapter
import com.bumptech.glide.RequestManager
import javax.inject.Inject

class SferaFragmentFactory @Inject constructor(
    private val glide: RequestManager
) : FragmentFactory() {
    override fun instantiate(classLoader: ClassLoader, className: String): Fragment {
        return when (className) {
            ProfileFragment::class.java.name -> ProfileFragment(
                adapterProfile = ProfileImagesAdapter(glide = glide),
                adapterMoments = MomentsAdapter(glide = glide),
                adapterChronices = ChroniciesAdapter(glide = glide),
                glide = glide
            )
            PeopleViewPagerFragment::class.java.name -> PeopleViewPagerFragment(glide = glide)
            else -> super.instantiate(classLoader, className)
        }
    }
}