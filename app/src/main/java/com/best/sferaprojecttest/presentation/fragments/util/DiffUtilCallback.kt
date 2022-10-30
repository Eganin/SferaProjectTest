package com.best.sferaprojecttest.presentation.fragments.util

import androidx.recyclerview.widget.DiffUtil
import com.best.sferaprojecttest.domain.models.ImageForList
import com.best.sferaprojecttest.domain.models.PeopleInfo

internal class ImageForListDiffUtilCallback : DiffUtil.ItemCallback<ImageForList>() {
    override fun areItemsTheSame(oldItem: ImageForList, newItem: ImageForList): Boolean {
        return oldItem.link == newItem.link
    }

    override fun areContentsTheSame(oldItem: ImageForList, newItem: ImageForList): Boolean {
        return oldItem == newItem
    }
}

internal class PeopleInfoDiffUtilCallback : DiffUtil.ItemCallback<PeopleInfo>() {
    override fun areItemsTheSame(oldItem: PeopleInfo, newItem: PeopleInfo): Boolean {
        return oldItem.action == newItem.action &&
                oldItem.imageLink == newItem.imageLink &&
                oldItem.title == newItem.title
    }

    override fun areContentsTheSame(oldItem: PeopleInfo, newItem: PeopleInfo): Boolean {
        return oldItem == newItem
    }
}