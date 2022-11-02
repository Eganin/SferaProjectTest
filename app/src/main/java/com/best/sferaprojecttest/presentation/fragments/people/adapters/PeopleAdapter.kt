package com.best.sferaprojecttest.presentation.fragments.people.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.TextViewCompat
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.best.sferaprojecttest.R
import com.best.sferaprojecttest.databinding.PeoplleViewHolderBinding
import com.best.sferaprojecttest.domain.models.PeopleInfo
import com.best.sferaprojecttest.presentation.fragments.util.PeopleInfoDiffUtilCallback
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager

class PeopleAdapter(private val glide: RequestManager) :
    ListAdapter<PeopleInfo, PeopleAdapter.PeopleViewHolder>(PeopleInfoDiffUtilCallback()) {

    inner class PeopleViewHolder(
        private val binding: PeoplleViewHolderBinding,
        private val changeState: ChangeStateToActionButton
    ) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: PeopleInfo) {
            glide
                .load(item.imageLink)
                .into(binding.peopleImageIv)

            binding.peopleNickname.text = item.title

            when (item.action) {
                PeopleInfo.PeopleAction.SUBSCRIBE -> {
                    changeState.changeStateToActive(itemView = itemView)
                }
                PeopleInfo.PeopleAction.UNSUBSCRIBE -> {
                    changeState.changeStateToInactive(itemView = itemView)
                }
            }

            binding.peopleActionBtn.setOnClickListener {
                when (item.action) {
                    PeopleInfo.PeopleAction.SUBSCRIBE -> {
                        item.action = PeopleInfo.PeopleAction.UNSUBSCRIBE
                        changeState.changeStateToInactive(itemView = itemView)
                    }
                    PeopleInfo.PeopleAction.UNSUBSCRIBE -> {
                        item.action = PeopleInfo.PeopleAction.SUBSCRIBE
                        changeState.changeStateToActive(itemView = itemView)
                    }
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PeopleViewHolder {
        val binding = PeoplleViewHolderBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return PeopleViewHolder(
            binding = binding,
            changeState = ChangeStateToActionButton.Base(binding = binding)
        )
    }

    override fun onBindViewHolder(holder: PeopleViewHolder, position: Int) {
        holder.bind(item = getItem(position))
    }
}