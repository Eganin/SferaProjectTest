package com.best.sferaprojecttest.presentation.fragments.people.adapters

import android.view.LayoutInflater
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

class PeopleAdapter (private val glide : RequestManager):
    ListAdapter<PeopleInfo, PeopleAdapter.PeopleViewHolder>(PeopleInfoDiffUtilCallback()) {

    inner class PeopleViewHolder(private val binding: PeoplleViewHolderBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: PeopleInfo) {
            glide
                .load(item.imageLink)
                .into(binding.peopleImageIv)

            binding.peopleNickname.text = item.title

            when(item.action){
                PeopleInfo.PeopleAction.SUBSCRIBE_ACTIVE->{
                    binding.peopleActionBtn.text=itemView.context.getString(R.string.subscribe_text)
                    TextViewCompat.setTextAppearance(binding.peopleActionBtn, R.style.PeopleActionSubscribeText)
                }
                PeopleInfo.PeopleAction.SUBSCRIBE_INACTIVE->{
                    binding.peopleActionBtn.text=itemView.context.getString(R.string.subscribe_text)
                    TextViewCompat.setTextAppearance(binding.peopleActionBtn, R.style.PeopleInactiveActionSubscribeText)
                }
                PeopleInfo.PeopleAction.UNSUBSCRIBE->{
                    binding.peopleActionBtn.text=itemView.context.getString(R.string.unsubscribe_text)
                    TextViewCompat.setTextAppearance(binding.peopleActionBtn, R.style.PeopleActionUnsubscribeText)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PeopleViewHolder {
        return PeopleViewHolder(
            binding = PeoplleViewHolderBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: PeopleViewHolder, position: Int) {
        holder.bind(item = getItem(position))
    }
}