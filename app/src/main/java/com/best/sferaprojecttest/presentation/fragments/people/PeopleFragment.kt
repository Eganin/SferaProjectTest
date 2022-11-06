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
import com.best.sferaprojecttest.presentation.fragments.people.adapters.PeopleAdapter
import com.best.sferaprojecttest.presentation.fragments.people.viewpager.TypePeopleList
import io.github.serpro69.kfaker.Faker

class PeopleFragment(
    private val peopleAdapter: PeopleAdapter,
    private val type: TypePeopleList,
    private val viewModel: PeopleViewModel
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
        Log.d("EEE",type.name)
        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        binding.peoplesRv.adapter = peopleAdapter
        when (type) {
            TypePeopleList.SUBSCRIBERS -> {
                viewModel.subscribersInfo.observe(viewLifecycleOwner) {
                    Log.d("EEE", "1")
                    Log.d("EEE", it.toString())
                    peopleAdapter.submitList(it)
                }
            }
            TypePeopleList.SUBSCRIPTIONS -> {
                viewModel.subscriptionsInfo.observe(viewLifecycleOwner) {
                    Log.d("EEE", "2")
                    Log.d("EEE", it.toString())
                    peopleAdapter.submitList(it)
                }
            }
            TypePeopleList.MUTUALLY -> {
                viewModel.mutuallyInfo.observe(viewLifecycleOwner) {
                    Log.d("EEE", "3")
                    Log.d("EEE", it.toString())
                    peopleAdapter.submitList(it)
                }
            }
        }
    }

}