package com.learn.android.aplikasiperpustakaantbm.presentation.ui.activity

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.learn.android.aplikasiperpustakaantbm.R
import com.learn.android.aplikasiperpustakaantbm.data.dao.BookDao
import com.learn.android.aplikasiperpustakaantbm.data.dao.PengunjungDao
import com.learn.android.aplikasiperpustakaantbm.data.dao.UserDao
import com.learn.android.aplikasiperpustakaantbm.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var mainBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainBinding.root)

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
        val navController = navHostFragment.navController

        mainBinding.bottomNavigationView.setupWithNavController(navController)

        navController.addOnDestinationChangedListener { _, destination, _ ->
            when (destination.id) {
                R.id.homeFragment -> showBottomNavigationBar()
                R.id.kategoriFragment -> showBottomNavigationBar()
                R.id.reminderFragment -> showBottomNavigationBar()
                R.id.laporanFragment -> showBottomNavigationBar()
                else -> hideBottomNavigationBar()
            }
        }
    }

    private fun showBottomNavigationBar() {
        mainBinding.bottomNavigationView.visibility = View.VISIBLE
        mainBinding.bottomAppBar.visibility = View.VISIBLE
    }

    private fun hideBottomNavigationBar() {
        mainBinding.bottomNavigationView.visibility = View.GONE
        mainBinding.bottomAppBar.visibility = View.GONE
    }

}