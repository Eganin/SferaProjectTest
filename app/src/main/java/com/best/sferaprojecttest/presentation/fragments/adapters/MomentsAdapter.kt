package com.best.sferaprojecttest.presentation.fragments.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.best.sferaprojecttest.databinding.AddViewHolderMomentsBinding
import com.best.sferaprojecttest.databinding.ImageForMomentsBinding
import com.best.sferaprojecttest.domain.models.ImageForList
import com.best.sferaprojecttest.presentation.fragments.util.ImageDiffUtilCallback
import com.bumptech.glide.Glide

class MomentsAdapter :
    ListAdapter<ImageForList, MomentsAdapter.MomentViewHolder>(ImageDiffUtilCallback()) {

    companion object {
        private const val TYPE_ADD = 0
        private const val TYPE_IMAGE = 1
    }

    private val imagesList: MutableList<ImageForList> = mutableListOf()

    abstract class MomentViewHolder(itemView: View) : ViewHolder(itemView)

    inner class ImageForMoments(private val binding: ImageForMomentsBinding) :
        MomentViewHolder(binding.root) {
        fun bind(item: ImageForList) {
            Glide
                .with(itemView.context)
                .load(item.link)
                .into(binding.imageMoment)
        }
    }

    inner class AddImageForMoments(binding: AddViewHolderMomentsBinding) :
        MomentViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MomentViewHolder {
        return when (viewType) {
            TYPE_ADD -> AddImageForMoments(
                binding = AddViewHolderMomentsBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )
            else -> ImageForMoments(
                binding = ImageForMomentsBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )
        }

    }

    override fun onBindViewHolder(holder: MomentViewHolder, position: Int) {
        when (holder) {
            is AddImageForMoments -> {}
            is ImageForMoments -> holder.bind(item = imagesList[position - 1])
        }
    }

    override fun getItemCount() = imagesList.size + 1

    override fun getItemViewType(position: Int): Int {
        return when (position) {
            0 -> TYPE_ADD
            else -> TYPE_IMAGE
        }
    }

}