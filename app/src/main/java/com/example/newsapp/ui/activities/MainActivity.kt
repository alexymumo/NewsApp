package com.example.newsapp.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentManager
import androidx.viewpager.widget.ViewPager
import com.example.newsapp.R
import com.example.newsapp.databinding.ActivityMainBinding
import com.example.newsapp.ui.adapters.ViewPagerAdapter
import com.google.android.material.tabs.TabLayout

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewPagerAdapter: ViewPagerAdapter
    private lateinit var viewPager: ViewPager


    private var Title = arrayOf<CharSequence>(
        "Articles",
        "Sports",
        "Tech",
        "Trending Topics"
    )
    private var tabs = 4



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        val fragmentManager: FragmentManager = this.supportFragmentManager
        viewPagerAdapter = ViewPagerAdapter(fragmentManager, Title, tabs)

        //viewPager = findViewById(R.id.viewPager)
        binding.viewPager.adapter = viewPagerAdapter

        //val tabLayout = findViewById<TabLayout>(R.id.tabLayout)
        binding.tabLayout.setupWithViewPager(binding.viewPager)
        binding.tabLayout.tabMode = TabLayout.MODE_SCROLLABLE

    }
}