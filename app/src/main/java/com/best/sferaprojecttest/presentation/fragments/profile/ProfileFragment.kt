package com.best.sferaprojecttest.presentation.fragments.profile

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.content.res.AppCompatResources.getColorStateList
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.best.sferaprojecttest.R
import com.best.sferaprojecttest.databinding.ProfileFragmentBinding
import com.best.sferaprojecttest.domain.models.ProfileInfo
import com.best.sferaprojecttest.presentation.fragments.UiState
import com.best.sferaprojecttest.presentation.fragments.profile.adapters.ChroniciesAdapter
import com.best.sferaprojecttest.presentation.fragments.profile.adapters.MomentsAdapter
import com.best.sferaprojecttest.presentation.fragments.profile.adapters.ProfileImagesAdapter
import com.best.sferaprojecttest.presentation.routing.Router
import com.best.sferaprojecttest.presentation.screens.MainActivity
import com.bumptech.glide.RequestManager
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ProfileFragment(
    private val adapterProfile: ProfileImagesAdapter,
    private val adapterMoments: MomentsAdapter,
    private val adapterChronices: ChroniciesAdapter,
    private val glide: RequestManager
) : Fragment() {

    private var _binding: ProfileFragmentBinding? = null
    private val binding get() = _binding!!
    private var listener: Router? = null
    private val profileViewModel: ProfileViewModel by viewModels()

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is MainActivity) {
            listener = context
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = ProfileFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        profileViewModel.init()
        setupViews()
        observeData()
    }

    private fun observeData() {
        profileViewModel.profileInfo.observe(viewLifecycleOwner) {
            fillProfileData(profileInfo = it)
        }
        profileViewModel.imagesForProfile.observe(viewLifecycleOwner) {
            adapterProfile.submitList(it)
        }
        profileViewModel.imagesForMoments.observe(viewLifecycleOwner) {
            adapterMoments.submitList(it)
        }
        profileViewModel.imagesForChronicies.observe(viewLifecycleOwner) {
            adapterChronices.submitList(it)
        }

        profileViewModel.uiState.observe(viewLifecycleOwner) {
            when (it) {
                is UiState.HideLoading -> binding.profileProgressBar.visibility = View.GONE

                is UiState.ShowLoading ->
                    binding.profileProgressBar.visibility = View.VISIBLE

                is UiState.ShowError ->
                    Snackbar.make(binding.root, it.message, Snackbar.LENGTH_SHORT).show()

            }
        }
    }

    private fun fillProfileData(profileInfo: ProfileInfo) {
        glide
            .load(profileInfo.avatarLink)
            .into(binding.profileImageIv)
        binding.ratingProfileTv.text = profileInfo.rating.toString()
        binding.mainToolbar.topAppBar.title = profileInfo.id
        binding.profileNicknameTv.text = profileInfo.nickName
        binding.languageValuesTv.text = profileInfo.languages
        binding.geolocationValuesTv.text = profileInfo.geolocations
    }

    private fun setupViews() {
        setupRecyclerViews()
        setupListeners()
    }

    private fun setupListeners() {
        binding.peopleBtn.setOnClickListener {
            listener?.openPeopleViewPagerFragment()
        }
        binding.aboutMeEditText.setOnFocusChangeListener { _, hasFocus ->
            if (hasFocus) binding.aboutMeTextInput.counterTextColor =
                getColorStateList(requireContext(), R.color.secondary_color)
        }
    }

    private fun setupRecyclerViews() {
        //create and setup Profile adapter
        binding.listImagesProfile.adapter = adapterProfile
        binding.listImagesProfile.suppressLayout(true)

        //create and setup Moments adapter
        binding.momentsRv.adapter = adapterMoments

        //create and setup chronicies adapter
        binding.chroniciesRv.adapter = adapterChronices
        binding.chroniciesRv.isVerticalFadingEdgeEnabled = true
        binding.chroniciesRv.suppressLayout(true)
    }
}
