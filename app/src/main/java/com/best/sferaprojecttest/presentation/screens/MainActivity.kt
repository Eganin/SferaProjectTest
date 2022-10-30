package com.best.sferaprojecttest.presentation.screens

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.best.sferaprojecttest.R
import com.best.sferaprojecttest.presentation.routing.Router

class MainActivity : AppCompatActivity(), Router {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.nav_host_fragment)
    }

    override fun openPeopleFragment() {
        openNewFragment {
            navigate(R.id.action_profileFragment_to_peopleFragment)
        }
    }

    override fun openProfileFragment() {
        openNewFragment {
            popBackStack()
        }
    }

    private fun openNewFragment(
        transaction : NavController.() -> Unit
    ){
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController
        navController.apply(transaction)
    }
}