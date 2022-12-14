package com.best.sferaprojecttest.presentation.fragments.rxjavatest

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.best.sferaprojecttest.databinding.AnimeFragmentBinding
import com.bumptech.glide.RequestManager
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CharacterFragment(
    private val glide: RequestManager
) : Fragment() {

    private var _binding: AnimeFragmentBinding? = null
    private val binding get() = _binding!!
    private val viewModel by viewModels<CharacterViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = AnimeFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.init()
        viewModel.info.observe(viewLifecycleOwner) {
            glide.load(it.imageLink).into(binding.animePoster)
            binding.descriptionCharacter.text = it.description
        }
    }
}