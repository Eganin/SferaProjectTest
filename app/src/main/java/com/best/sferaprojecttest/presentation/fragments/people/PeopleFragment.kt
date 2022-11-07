package com.best.sferaprojecttest.presentation.fragments.people

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.best.sferaprojecttest.databinding.PeopleFragmentBinding
import com.best.sferaprojecttest.domain.models.PeopleInfo
import com.best.sferaprojecttest.presentation.fragments.UiState
import com.best.sferaprojecttest.presentation.fragments.people.adapters.PeopleAdapter
import com.best.sferaprojecttest.presentation.fragments.people.viewpager.TypePeopleList
import com.bumptech.glide.RequestManager
import com.google.android.material.snackbar.Snackbar
import io.github.serpro69.kfaker.Faker

class PeopleFragment(
    private val type: TypePeopleList,
    private val viewModel: PeopleViewModel,
    private val glide: RequestManager
) : Fragment() {

    private var _binding: PeopleFragmentBinding? = null
    private val binding get() = _binding!!
    private lateinit var peopleAdapter: PeopleAdapter

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

    override fun onResume() {
        super.onResume()
        when (type) {
            TypePeopleList.SUBSCRIBERS -> viewModel.changePositionForViewPager(position = 0)
            TypePeopleList.SUBSCRIPTIONS -> viewModel.changePositionForViewPager(position = 1)
            TypePeopleList.MUTUALLY -> viewModel.changePositionForViewPager(position = 2)
        }
    }


    private fun setupRecyclerView() {
        peopleAdapter = PeopleAdapter(glide = glide, type = type)
        binding.peoplesRv.adapter = peopleAdapter
        viewModel.uiState.observe(viewLifecycleOwner) {
            when (it) {
                is UiState.HideLoading -> binding.peopleProgressBar.visibility = View.GONE

                is UiState.ShowLoading ->{
                    binding.peopleProgressBar.visibility = View.VISIBLE
                }

                is UiState.ShowError ->
                    Snackbar.make(binding.root, it.message, Snackbar.LENGTH_SHORT).show()

            }
        }
        when (type) {
            TypePeopleList.SUBSCRIBERS -> {
                viewModel.subscribersInfo.observe(viewLifecycleOwner) {
                    peopleAdapter.submitList(it)
                }
            }
            TypePeopleList.SUBSCRIPTIONS -> {
                viewModel.subscriptionsInfo.observe(viewLifecycleOwner) {
                    peopleAdapter.submitList(it)
                }
            }
            TypePeopleList.MUTUALLY -> {
                viewModel.mutuallyInfo.observe(viewLifecycleOwner) {
                    peopleAdapter.submitList(it)
                    Log.d("EEE", it.size.toString())
                }
            }
        }
    }

}