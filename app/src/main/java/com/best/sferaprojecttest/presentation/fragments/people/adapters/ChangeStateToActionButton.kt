package com.best.sferaprojecttest.presentation.fragments.people.adapters

import android.view.View
import androidx.core.widget.TextViewCompat
import com.best.sferaprojecttest.R
import com.best.sferaprojecttest.databinding.PeoplleViewHolderBinding
import com.best.sferaprojecttest.domain.models.PeopleInfo

interface ChangeStateToActionButton {
    fun changeStateToActive(itemView: View,item : PeopleInfo)
    fun changeStateToInactive(itemView: View)

    class Base(private val binding: PeoplleViewHolderBinding) : ChangeStateToActionButton {
        override fun changeStateToActive(itemView: View,item: PeopleInfo) {
            binding.peopleActionBtn.text = itemView.context.getString(R.string.subscribe_text)
            TextViewCompat.setTextAppearance(
                binding.peopleActionBtn,
                R.style.PeopleActionSubscribeText
            )
        }

        override fun changeStateToInactive(itemView: View) {
            binding.peopleActionBtn.text = itemView.context.getString(R.string.unsubscribe_text)
            TextViewCompat.setTextAppearance(
                binding.peopleActionBtn,
                R.style.PeopleActionUnsubscribeText
            )
        }

    }

    class SubscriptionsOrMutually(
        private val binding: PeoplleViewHolderBinding,
        private val listener: ActionButtonClickListener
    ) : ChangeStateToActionButton {
        override fun changeStateToActive(itemView: View,item: PeopleInfo) {
            binding.peopleActionBtn.text = itemView.context.getString(R.string.subscribe_text)
            TextViewCompat.setTextAppearance(
                binding.peopleActionBtn,
                R.style.PeopleActionSubscribeText
            )
            listener.removePeopleInList(item=item)
        }

        override fun changeStateToInactive(itemView: View) {
            binding.peopleActionBtn.text = itemView.context.getString(R.string.unsubscribe_text)
            TextViewCompat.setTextAppearance(
                binding.peopleActionBtn,
                R.style.PeopleActionUnsubscribeText
            )
        }

    }
}