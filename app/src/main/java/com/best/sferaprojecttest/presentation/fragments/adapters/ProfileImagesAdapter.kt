package com.best.sferaprojecttest.presentation.fragments.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.best.sferaprojecttest.databinding.ImageForProfileBinding
import com.best.sferaprojecttest.domain.models.ImageForList
import com.best.sferaprojecttest.presentation.fragments.util.ImageDiffUtilCallback
import com.bumptech.glide.Glide


internal class ProfileImagesAdapter :
    ListAdapter<ImageForList, ProfileImagesAdapter.ImageForProfile>(ImageDiffUtilCallback()) {

    private val imagesList: MutableList<ImageForList> = mutableListOf()

    inner class ImageForProfile(private val binding: ImageForProfileBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: ImageForList) {
            Glide
                .with(itemView.context)
                .load(item.link)
                .into(binding.imageProfile)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageForProfile {
        val binding =
            ImageForProfileBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ImageForProfile(binding = binding)
    }

    override fun onBindViewHolder(holder: ImageForProfile, position: Int) =
        holder.bind(item = imagesList[position])


    override fun getItemCount() = imagesList.size
}