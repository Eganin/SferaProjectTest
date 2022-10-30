package com.best.sferaprojecttest.presentation.fragments.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.best.sferaprojecttest.databinding.AddViewHolderChroniciesBinding
import com.best.sferaprojecttest.databinding.ImageForChroniciesBinding
import com.best.sferaprojecttest.domain.models.ImageForList
import com.best.sferaprojecttest.presentation.fragments.util.ImageDiffUtilCallback
import com.bumptech.glide.Glide

class ChroniciesAdapter :
    ListAdapter<ImageForList, ChroniciesAdapter.ChroniciesViewHolder>(ImageDiffUtilCallback()) {

    companion object {
        private const val TYPE_ADD = 0
        private const val TYPE_IMAGE = 1
    }

    private val imagesList: MutableList<ImageForList> = mutableListOf()

    abstract class ChroniciesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    inner class ImageForChronicies(private val binding: ImageForChroniciesBinding) :
        ChroniciesViewHolder(itemView = binding.root) {
        fun bind(item: ImageForList) {
            Glide
                .with(itemView.context)
                .load(item.link)
                .into(binding.imageChronicies)
        }
    }

    inner class AddImageForChronicies(binding: AddViewHolderChroniciesBinding) :
        ChroniciesViewHolder(itemView = binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChroniciesViewHolder {
        return when (viewType) {
            TYPE_ADD -> AddImageForChronicies(
                binding = AddViewHolderChroniciesBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )
            else -> ImageForChronicies(
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
            is AddImageForChronicies -> {}
            is ImageForChronicies -> holder.bind(item = imagesList[position - 1])
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