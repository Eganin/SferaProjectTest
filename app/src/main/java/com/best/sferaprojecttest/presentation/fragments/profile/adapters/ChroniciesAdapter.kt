package com.best.sferaprojecttest.presentation.fragments.profile.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.best.sferaprojecttest.databinding.AddViewHolderChroniciesBinding
import com.best.sferaprojecttest.databinding.ImageForChroniciesBinding
import com.best.sferaprojecttest.domain.models.ImageForList
import com.best.sferaprojecttest.presentation.fragments.util.ImageForListDiffUtilCallback
import com.bumptech.glide.Glide

class ChroniciesAdapter :
    ListAdapter<ImageForList, ChroniciesAdapter.ChroniciesViewHolder>(ImageForListDiffUtilCallback()) {

    companion object {
        private const val TYPE_ADD = 0
        private const val TYPE_IMAGE = 1
    }

    abstract class ChroniciesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    inner class ImageForChroniciesViewHolder(private val binding: ImageForChroniciesBinding) :
        ChroniciesViewHolder(itemView = binding.root) {
        fun bind(item: ImageForList) {
            Glide
                .with(itemView.context)
                .load(item.link)
                .into(binding.imageChronicies)
        }
    }

    inner class AddImageForChroniciesViewHolder(binding: AddViewHolderChroniciesBinding) :
        ChroniciesViewHolder(itemView = binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChroniciesViewHolder {
        return when (viewType) {
            TYPE_ADD -> AddImageForChroniciesViewHolder(
                binding = AddViewHolderChroniciesBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )
            else -> ImageForChroniciesViewHolder(
                binding = ImageForChroniciesBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )
        }
    }

    override fun onBindViewHolder(holder: ChroniciesViewHolder, position: Int) {
        when (holder) {
            is AddImageForChroniciesViewHolder -> {}
            is ImageForChroniciesViewHolder -> holder.bind(item = getItem(position - 1))
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