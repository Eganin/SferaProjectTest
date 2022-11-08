package com.best.sferaprojecttest.presentation.screens

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import com.best.sferaprojecttest.R
import com.best.sferaprojecttest.presentation.fragments.SferaFragmentFactory
import com.best.sferaprojecttest.presentation.routing.Router
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity(), Router {

    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.nav_host_fragment)
        navController =
            (supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment).navController
        window.statusBarColor = ContextCompat.getColor(this, R.color.black)
    }

    override fun openPeopleViewPagerFragment() {
        openNewFragment {
            navigate(R.id.action_profileFragment_to_peopleViewPagerFragment)
        }
    }

    override fun openProfileFragment() {
        openNewFragment {
            popBackStack()
        }
    }

    private fun openNewFragment(
        transaction: NavController.() -> Unit
    ) {
        navController.apply(transaction)
    }
}