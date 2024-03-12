package com.ducnm.bruhmovie

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowInsets
import androidx.activity.enableEdgeToEdge
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.createGraph
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.fragment
import androidx.navigation.navigation
import androidx.navigation.ui.setupWithNavController
import com.ducnm.bruhmovie.databinding.ActivityMainBinding
import com.ducnm.bruhmovie.ui.movie.MovieFragment
import com.ducnm.bruhmovie.ui.others.OtherFragment
import com.ducnm.bruhmovie.ui.tv.TvFragment
import com.ducnm.bruhmovie.ultil.Define
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var navController: NavController

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        setUpBottomNavigation()
    }

    private fun setUpBottomNavigation(){

        val windowInset = WindowCompat.getInsetsController(window, window.decorView)
        //windowInset.hide(WindowInsetsCompat.Type.statusBars())


        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController = navHostFragment.navController
        binding.bottomNav.setupWithNavController(navController = navController)
    }
}