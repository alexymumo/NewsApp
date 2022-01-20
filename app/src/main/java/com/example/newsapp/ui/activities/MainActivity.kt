package com.example.newsapp.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.newsapp.R

class MainActivity : AppCompatActivity() {
    private lateinit var appBarConfiguration: AppBarConfiguration
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navController = findNavController(R.id.host_fragment)
        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.sportsFragment,
                R.id.trendingFragment
            ) ,
        )

        setupActionBarWithNavController(navController, appBarConfiguration)
        navController.addOnDestinationChangedListener { _, destination, _->
            destination.id == R.id.sportsFragment ||
            destination.id == R.id.trendingFragment ||
            destination.id == R.id.articleFragment
        }
        )
    }
}