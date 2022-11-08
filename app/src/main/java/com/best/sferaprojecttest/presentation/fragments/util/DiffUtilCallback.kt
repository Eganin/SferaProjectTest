package com.best.sferaprojecttest.presentation.fragments.util

import android.os.Bundle
import android.util.Log
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

    override fun getChangePayload(oldItem: PeopleInfo, newItem: PeopleInfo): Any? {
        if (oldItem.id == newItem.id) {
            return if (oldItem.action == newItem.action) {
                super.getChangePayload(oldItem, newItem)
            } else {
                val diff = Bundle()
                diff.putString(ARG_ACTION, newItem.action.name)
                diff
            }
        }

        return super.getChangePayload(oldItem, newItem)
    }

    companion object{
        const val ARG_ACTION ="ARG_ACTION"
    }
}