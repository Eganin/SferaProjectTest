package com.best.sferaprojecttest.presentation.fragments.people.adapters

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.best.sferaprojecttest.databinding.PeoplleViewHolderBinding
import com.best.sferaprojecttest.domain.models.PeopleInfo
import com.best.sferaprojecttest.presentation.fragments.people.viewpager.TypePeopleList
import com.best.sferaprojecttest.presentation.fragments.util.PeopleInfoDiffUtilCallback
import com.best.sferaprojecttest.presentation.fragments.util.PeopleInfoDiffUtilCallback.Companion.ARG_ACTION
import com.bumptech.glide.RequestManager

interface ActionButtonClickListener {
    fun removePeopleInList(item: PeopleInfo)
}

class PeopleAdapter(
    private val glide: RequestManager,
    private val type: TypePeopleList
) :
    ListAdapter<PeopleInfo, PeopleAdapter.PeopleViewHolder>(PeopleInfoDiffUtilCallback()),
    ActionButtonClickListener {

    inner class PeopleViewHolder(
        private val binding: PeoplleViewHolderBinding,
        private val changeState: ChangeStateToActionButton
    ) :
        RecyclerView.ViewHolder(binding.root) {

        fun update(bundle: Bundle, item: PeopleInfo) {
            if (bundle.containsKey(ARG_ACTION)) {
                when (bundle.getString(ARG_ACTION)) {
                    PeopleInfo.PeopleAction.SUBSCRIBE.name -> {
                        changeState.changeStateToActive(itemView = itemView, item = item)
                    }
                    PeopleInfo.PeopleAction.UNSUBSCRIBE.name -> {
                        changeState.changeStateToInactive(itemView = itemView)
                    }
                }
            }
        }

        fun bind(item: PeopleInfo) {
            glide
                .load(item.imageLink)
                .into(binding.peopleImageIv)

            binding.peopleNickname.text = item.title

            when (item.action) {
                PeopleInfo.PeopleAction.SUBSCRIBE -> {
                    changeState.changeStateToActive(itemView = itemView, item = item)
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
                        changeState.changeStateToActive(itemView = itemView, item = item)
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
            changeState = when (type) {
                TypePeopleList.SUBSCRIPTIONS, TypePeopleList.MUTUALLY ->
                    ChangeStateToActionButton.SubscriptionsOrMutually(
                        binding = binding,
                        listener = this
                    )
                TypePeopleList.SUBSCRIBERS -> ChangeStateToActionButton.Base(binding = binding)
            }
        )
    }

    override fun onBindViewHolder(holder: PeopleViewHolder, position: Int, payloads: List<Any>) {
        val item = getItem(position)
        if (payloads.isEmpty() || payloads.first() !is Bundle) {
            holder.bind(item = item)
        } else {
            val bundle = payloads.first() as Bundle
            holder.update(bundle = bundle, item = item)
        }
    }

    override fun onBindViewHolder(holder: PeopleViewHolder, position: Int) {
        onBindViewHolder(holder = holder, position = position, payloads = emptyList())
    }

    override fun removePeopleInList(item: PeopleInfo) {
        val position = currentList.indexOf(item)
        val myCurrentList = currentList.toMutableList()
        myCurrentList.removeAt(position)
        submitList(myCurrentList)
    }
}