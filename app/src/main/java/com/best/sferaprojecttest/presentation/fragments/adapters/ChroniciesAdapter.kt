package com.best.sferaprojecttest.presentation.fragments.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.best.sferaprojecttest.databinding.ImageForChroniciesBinding
import com.best.sferaprojecttest.domain.models.ImageForList
import com.best.sferaprojecttest.presentation.fragments.util.DiffUtilCallback
import com.bumptech.glide.Glide

class ChroniciesAdapter : RecyclerView.Adapter<ChroniciesAdapter.ImageForChronicies>() {

    private val imagesList: MutableList<ImageForList> = mutableListOf()

    inner class ImageForChronicies(private val binding: ImageForChroniciesBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: ImageForList) {
            Glide
                .with(itemView.context)
                .load(item.link)
                .into(binding.imageChronicies)
        }
    }

    fun setList(list: List<ImageForList>) {
        val diffCallback = DiffUtilCallback(oldList = imagesList, newList = list)
        val diff = DiffUtil.calculateDiff(diffCallback)
        imagesList.clear()
        imagesList.addAll(list)
        diff.dispatchUpdatesTo(this)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageForChronicies {
        val binding =
            ImageForChroniciesBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        return ImageForChronicies(binding = binding)
    }

    override fun onBindViewHolder(holder: ImageForChronicies, position: Int) =
        holder.bind(item = imagesList[position])

    override fun getItemCount() = imagesList.size
}