package com.best.sferaprojecttest.presentation.fragments.profile.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.best.sferaprojecttest.databinding.ImageForProfileBinding
import com.best.sferaprojecttest.domain.models.ImageForList
import com.best.sferaprojecttest.presentation.fragments.util.ImageForListDiffUtilCallback
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager
import javax.inject.Inject


class ProfileImagesAdapter (
    private val glide: RequestManager
) :
    ListAdapter<ImageForList, ProfileImagesAdapter.ImageForProfileViewHolder>(
        ImageForListDiffUtilCallback()
    ) {

    inner class ImageForProfileViewHolder(private val binding: ImageForProfileBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: ImageForList) {
            glide
                .load(item.link)
                .into(binding.imageProfile)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageForProfileViewHolder {

        val binding =
            ImageForProfileBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ImageForProfileViewHolder(binding = binding)
    }

    override fun onBindViewHolder(holder: ImageForProfileViewHolder, position: Int) =
        holder.bind(item = getItem(position))
}