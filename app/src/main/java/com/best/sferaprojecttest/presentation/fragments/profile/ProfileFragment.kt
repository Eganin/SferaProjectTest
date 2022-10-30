package com.best.sferaprojecttest.presentation.fragments.profile

import android.os.Bundle
import android.view.Display
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.best.sferaprojecttest.R
import com.best.sferaprojecttest.databinding.ProfileFragmentBinding
import com.best.sferaprojecttest.domain.models.ImageForList
import com.best.sferaprojecttest.presentation.fragments.adapters.ChroniciesAdapter
import com.best.sferaprojecttest.presentation.fragments.adapters.MomentsAdapter
import com.best.sferaprojecttest.presentation.fragments.adapters.ProfileImagesAdapter
import com.bumptech.glide.Glide

class ProfileFragment : Fragment() {

    private var _binding: ProfileFragmentBinding? = null

    private val binding get() = _binding!!

    private lateinit var adapterProfile: ProfileImagesAdapter
    private lateinit var adapterMoments: MomentsAdapter
    private lateinit var adapterChronices: ChroniciesAdapter

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
        setupViews()
    }

    private fun setupViews() {
        setupRecyclerViews()
        Glide
            .with(requireContext())
            .load("https://i.pinimg.com/736x/7e/ce/c4/7ecec434137d1fcbe023db38e06c1260.jpg")
            .into(binding.profileImageIv)
        binding.ratingProfileTv.text= "5.0"
        binding.mainToolbar.topAppBar.title =getString(R.string.test_id)
        binding.profileNicknameTv.text = "Eren Jager"
        binding.languageValuesTv.text = "English, Japanese"
        binding.geolocationValuesTv.text ="Paradise"
    }

    private fun setupRecyclerViews() {
        val listImagesForProfile =
            listOf(
                ImageForList(link = "https://i.pinimg.com/736x/7e/ce/c4/7ecec434137d1fcbe023db38e06c1260.jpg"),
                ImageForList(link = "https://cloudfront-us-east-1.images.arcpublishing.com/gruporepublica/3SJFG4PNVZCTPEFICIMBX3GBNI.jpg"),
                ImageForList(link = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRAOx2RPl8fc_NYxNNpuFM26XqTphDKOrVVzw&usqp=CAU"),
                ImageForList(link = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS_SBzlRLLwDLMkPqQpgiwwAXru6zTv9TgllJBx1YtV3K7Em9AZ1maJ9PbmLKxwZxEcTWw&usqp=CAU"),
            ).toMutableList()

        val listImagesForMoments =
            listOf(
                ImageForList(link = "https://i.pinimg.com/736x/7e/ce/c4/7ecec434137d1fcbe023db38e06c1260.jpg"),
                ImageForList(link = "https://cloudfront-us-east-1.images.arcpublishing.com/gruporepublica/3SJFG4PNVZCTPEFICIMBX3GBNI.jpg"),
                ImageForList(link = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRAOx2RPl8fc_NYxNNpuFM26XqTphDKOrVVzw&usqp=CAU"),
                ImageForList(link = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRAOx2RPl8fc_NYxNNpuFM26XqTphDKOrVVzw&usqp=CAU"),
                ImageForList(link = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS_SBzlRLLwDLMkPqQpgiwwAXru6zTv9TgllJBx1YtV3K7Em9AZ1maJ9PbmLKxwZxEcTWw&usqp=CAU"),
            ).toMutableList()

        val listImagesForChronicies =
            listOf(
                ImageForList(link = "https://i.pinimg.com/736x/7e/ce/c4/7ecec434137d1fcbe023db38e06c1260.jpg"),
                ImageForList(link = "https://i.pinimg.com/736x/7e/ce/c4/7ecec434137d1fcbe023db38e06c1260.jpg"),
                ImageForList(link = "https://cloudfront-us-east-1.images.arcpublishing.com/gruporepublica/3SJFG4PNVZCTPEFICIMBX3GBNI.jpg"),
                ImageForList(link = "https://cloudfront-us-east-1.images.arcpublishing.com/gruporepublica/3SJFG4PNVZCTPEFICIMBX3GBNI.jpg"),
                ImageForList(link = "https://cloudfront-us-east-1.images.arcpublishing.com/gruporepublica/3SJFG4PNVZCTPEFICIMBX3GBNI.jpg"),
                ImageForList(link = "https://cloudfront-us-east-1.images.arcpublishing.com/gruporepublica/3SJFG4PNVZCTPEFICIMBX3GBNI.jpg"),
                ImageForList(link = "https://cloudfront-us-east-1.images.arcpublishing.com/gruporepublica/3SJFG4PNVZCTPEFICIMBX3GBNI.jpg"),
                ImageForList(link = "https://cloudfront-us-east-1.images.arcpublishing.com/gruporepublica/3SJFG4PNVZCTPEFICIMBX3GBNI.jpg"),
                ImageForList(link = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRAOx2RPl8fc_NYxNNpuFM26XqTphDKOrVVzw&usqp=CAU"),
                ImageForList(link = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRAOx2RPl8fc_NYxNNpuFM26XqTphDKOrVVzw&usqp=CAU"),
                ImageForList(link = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS_SBzlRLLwDLMkPqQpgiwwAXru6zTv9TgllJBx1YtV3K7Em9AZ1maJ9PbmLKxwZxEcTWw&usqp=CAU"),
            ).toMutableList()

        //create and setup Profile adapter
        adapterProfile = ProfileImagesAdapter()
        binding.listImagesProfile.adapter = adapterProfile
        adapterProfile.submitList(listImagesForProfile)

        //create and setup Moments adapter
        adapterMoments = MomentsAdapter()
        binding.momentsRv.adapter = adapterMoments
        adapterMoments.submitList(listImagesForMoments)

        //create and setup chronicies adapter
        adapterChronices = ChroniciesAdapter()
        binding.chroniciesRv.adapter = adapterChronices
        adapterChronices.submitList(listImagesForChronicies)
    }
}
