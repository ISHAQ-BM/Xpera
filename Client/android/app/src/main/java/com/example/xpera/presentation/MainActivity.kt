package com.example.xpera.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.xpera.R
import com.example.xpera.databinding.ActivityMainBinding

import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var navController: NavController
    private var binding: ActivityMainBinding? = null
    private val viewModel: MainViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController = navHostFragment.navController

        if (viewModel.isUserAuthenticated && viewModel.isEmailVerified)
            navController.navigate(R.id.bottom_nav_graph)
        else if (viewModel.isUserAuthenticated && !viewModel.isEmailVerified)
            navController.navigate(R.id.verificationEmailFragment)

        binding?.bottomNavBar?.setupWithNavController(navController)

        navController.addOnDestinationChangedListener { _, destination, _ ->
            when (destination.id) {
                R.id.verificationEmailFragment -> hideBottomNav()
                R.id.successFragment -> hideBottomNav()
                R.id.loginFragment -> hideBottomNav()
                R.id.signupFragment -> hideBottomNav()
                else -> showBottomNav()
            }

        }


    }

    private fun showBottomNav() {
        binding?.bottomNavBar?.visibility = View.VISIBLE

    }

    private fun hideBottomNav() {
        binding?.bottomNavBar?.visibility = View.GONE

    }


}