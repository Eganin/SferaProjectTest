package com.best.sferaprojecttest.presentation.fragments.util

import androidx.recyclerview.widget.DiffUtil
import com.best.sferaprojecttest.domain.models.ImageForList

class ImageDiffUtilCallback : DiffUtil.ItemCallback<ImageForList>() {
    override fun areItemsTheSame(oldItem: ImageForList, newItem: ImageForList): Boolean =
        oldItem == newItem

    override fun areContentsTheSame(oldItem: ImageForList, newItem: ImageForList): Boolean =
        oldItem == newItem

}