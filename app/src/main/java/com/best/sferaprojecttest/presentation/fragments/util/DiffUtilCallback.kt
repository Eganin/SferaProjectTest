package com.best.sferaprojecttest.presentation.fragments.util

import androidx.recyclerview.widget.DiffUtil
import com.best.sferaprojecttest.domain.models.ImageForList

class DiffUtilCallback(
    private val oldList: List<ImageForList>,
    private val newList: List<ImageForList>
) : DiffUtil.Callback() {

    override fun getOldListSize() = oldList.size

    override fun getNewListSize() = newList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition].link == newList[newItemPosition].link
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition] == newList[newItemPosition]
    }
}