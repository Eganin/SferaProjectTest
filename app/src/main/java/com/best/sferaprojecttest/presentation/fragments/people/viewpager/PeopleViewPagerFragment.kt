package com.best.sferaprojecttest.presentation.fragments.people.viewpager

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.best.sferaprojecttest.databinding.PeopleViewPagerBinding
import com.best.sferaprojecttest.presentation.fragments.people.PeopleViewModel
import com.best.sferaprojecttest.presentation.fragments.people.adapters.PeopleAdapter
import com.best.sferaprojecttest.presentation.routing.Router
import com.best.sferaprojecttest.presentation.screens.MainActivity
import com.google.android.material.tabs.TabLayoutMediator

class PeopleViewPagerFragment(
    private val peopleAdapterOne: PeopleAdapter,
    private val peopleAdapterTwo: PeopleAdapter,
    private val peopleAdapterThree: PeopleAdapter,
) : Fragment() {
    private var _binding: PeopleViewPagerBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewPagerAdapter: ViewPagerAdapter
    private var listener: Router? = null
    private val viewModel: PeopleViewModel by viewModels()

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is MainActivity) listener = context
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = PeopleViewPagerBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
        listener = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupListeners()
        viewModel.init()
        viewPagerAdapter =
            ViewPagerAdapter(
                peopleAdapterOne,
                peopleAdapterTwo,
                peopleAdapterThree,
                fragment = this,
                viewModel = viewModel
            )
        binding.pager.adapter = viewPagerAdapter
        val tabsList = listOf("SUBSCRIBERS", "SUBSCRIPTIONS", "MUTUALLY")
        TabLayoutMediator(binding.tabLayout, binding.pager) { tab, position ->
            tab.text = tabsList[position]
        }.attach()
    }

    private fun setupListeners() {
        binding.peopleToolbar.topAppBar.setNavigationOnClickListener {
            listener?.openProfileFragment()
        }
    }
}