package com.best.sferaprojecttest.presentation.fragments.profile.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.best.sferaprojecttest.databinding.AddViewHolderMomentsBinding
import com.best.sferaprojecttest.databinding.ImageForMomentsBinding
import com.best.sferaprojecttest.domain.models.ImageForList
import com.best.sferaprojecttest.presentation.fragments.util.ImageForListDiffUtilCallback
import com.bumptech.glide.RequestManager

class MomentsAdapter (
    private val glide: RequestManager
) : ListAdapter<ImageForList, MomentsAdapter.MomentViewHolder>(ImageForListDiffUtilCallback()) {

    companion object {
        private const val TYPE_ADD = 0
        private const val TYPE_IMAGE = 1
    }

    abstract class MomentViewHolder(itemView: View) : ViewHolder(itemView)

    inner class ImageForMomentsViewHolder(private val binding: ImageForMomentsBinding) :
        MomentViewHolder(binding.root) {
        fun bind(item: ImageForList) {
            glide
                .load(item.link)
                .into(binding.imageMoment)
        }
    }

    inner class AddImageForMomentsViewHolder(binding: AddViewHolderMomentsBinding) :
        MomentViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MomentViewHolder {
        return when (viewType) {
            TYPE_ADD -> AddImageForMomentsViewHolder(
                binding = AddViewHolderMomentsBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )
            else -> ImageForMomentsViewHolder(
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
            is AddImageForMomentsViewHolder -> {}
            is ImageForMomentsViewHolder -> holder.bind(item = getItem(position - 1))
        }
    }

    override fun getItemCount() = super.getItemCount() + 1

    override fun getItemViewType(position: Int): Int {
        return when (position) {
            0 -> TYPE_ADD
            else -> TYPE_IMAGE
        }
    }

}