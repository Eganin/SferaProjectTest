package com.best.sferaprojecttest.presentation.fragments.util

import androidx.recyclerview.widget.DiffUtil
import com.best.sferaprojecttest.domain.models.ImageForList

class ImageForListDiffUtilCallback: DiffUtil.ItemCallback<ImageForList>(){
    override fun areItemsTheSame(oldItem: ImageForList, newItem: ImageForList): Boolean {
        return oldItem.link == newItem.link
    }

    override fun areContentsTheSame(oldItem: ImageForList, newItem: ImageForList): Boolean {
        return oldItem== newItem
    }
}