package com.best.sferaprojecttest.presentation.fragments.people.viewpager

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.appcompat.widget.SearchView
import androidx.appcompat.widget.SearchView.SearchAutoComplete
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.best.sferaprojecttest.R
import com.best.sferaprojecttest.databinding.PeopleViewPagerBinding
import com.best.sferaprojecttest.presentation.fragments.people.PeopleViewModel
import com.best.sferaprojecttest.presentation.routing.Router
import com.best.sferaprojecttest.presentation.screens.MainActivity
import com.bumptech.glide.RequestManager
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PeopleViewPagerFragment(
    private val glide: RequestManager
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
                glide = glide,
                fragment = this,
                viewModel = viewModel
            )
        binding.pager.adapter = viewPagerAdapter
        val tabsList = listOf(
            getString(R.string.subscribers_tab),
            getString(R.string.subscriptions_tab),
            getString(R.string.mutually_tab)
        )
        TabLayoutMediator(binding.tabLayout, binding.pager) { tab, position ->
            tab.text = tabsList[position]
        }.attach()
    }

    private fun setupListeners() {
        binding.peopleToolbar.topAppBar.setNavigationOnClickListener {
            listener?.openProfileFragment()
        }
        binding.peopleToolbar.topAppBar.setOnMenuItemClickListener {
            when (it.itemId) {
                R.id.search_people -> {
                    val searchView = it.actionView as SearchView
                    searchView.queryHint = context?.getString(R.string.search)
                    searchView.setIconifiedByDefault(false)
                    //find edit text in Search view
                    val ll = searchView.getChildAt(0) as LinearLayout
                    val ll2 = ll.getChildAt(2) as LinearLayout
                    val ll3 = ll2.getChildAt(1) as LinearLayout
                    val autoComplete = ll3.getChildAt(0) as SearchAutoComplete

                    autoComplete.setHintTextColor(
                        ContextCompat.getColor(
                            requireContext(),
                            R.color.hint_color
                        )
                    )

                    autoComplete.setTextColor(
                        ContextCompat.getColor(
                            requireContext(),
                            R.color.on_primary_color
                        )
                    )

                    searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
                        override fun onQueryTextSubmit(query: String?): Boolean {
                            return false
                        }

                        override fun onQueryTextChange(newText: String?): Boolean {
                            viewModel.filterList(filterNickName = newText.toString())
                            return false
                        }
                    })
                }
            }
            true
        }
    }
}