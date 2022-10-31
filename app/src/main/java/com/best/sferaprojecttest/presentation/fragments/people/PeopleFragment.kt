package com.best.sferaprojecttest.presentation.fragments.people

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.best.sferaprojecttest.databinding.PeopleFragmentBinding
import com.best.sferaprojecttest.domain.models.PeopleInfo
import com.best.sferaprojecttest.presentation.fragments.people.adapters.PeopleAdapter
import com.best.sferaprojecttest.presentation.routing.Router
import com.best.sferaprojecttest.presentation.screens.MainActivity

class PeopleFragment (
    private val peopleAdapter : PeopleAdapter
) : Fragment() {

    private var _binding: PeopleFragmentBinding? = null
    private val binding get() = _binding!!
    private var listener: Router? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if(context is MainActivity){
            listener=context
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = PeopleFragmentBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupListeners()
        setupRecyclerView()
    }

    private fun setupListeners(){
        binding.peopleToolbar.topAppBar.setNavigationOnClickListener {
            listener?.openProfileFragment()
        }
    }

    private fun setupRecyclerView(){
        val peopleList = listOf(
            PeopleInfo(
                title = "Eren Jager",
                imageLink = "https://i.pinimg.com/originals/7f/fc/2c/7ffc2cbc04b0c3cfbacfa51297b96966.jpg",
                action = PeopleInfo.PeopleAction.SUBSCRIBE_ACTIVE
            ),
            PeopleInfo(
                title = "Levi Ackerman",
                imageLink = "https://i.pinimg.com/736x/cf/8c/34/cf8c340732e4c2c8152780a4cc636895.jpg",
                action = PeopleInfo.PeopleAction.SUBSCRIBE_INACTIVE
            ),
            PeopleInfo(
                title = "Mikasa Ackerman",
                imageLink = "https://www.absoluteanime.com/attack_on_titan/mikasa%5B2%5D.jpg",
                action = PeopleInfo.PeopleAction.UNSUBSCRIBE
            ),
        )
        binding.peoplesRv.adapter=peopleAdapter
        peopleAdapter.submitList(peopleList)
    }
}