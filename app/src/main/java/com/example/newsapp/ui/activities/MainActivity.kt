package com.example.newsapp.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentManager
import androidx.viewpager.widget.ViewPager
import com.example.newsapp.R
import com.example.newsapp.ui.adapters.ViewPagerAdapter
import com.google.android.material.tabs.TabLayout

class MainActivity : AppCompatActivity() {
    var viewPagerAdapter: ViewPagerAdapter? = null
    var viewPager: ViewPager? = null

    var Title = arrayOf<CharSequence>(
        "Articles",
        "Sports",
        "Tech",
        "Trending Topics"
    )
    var tabs = 4

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fragmentManager: FragmentManager? = this.supportFragmentManager
        viewPagerAdapter = ViewPagerAdapter(fragmentManager, Title, tabs)

        viewPager = findViewById(R.id.viewPager)

        val tabLayout = findViewById<TabLayout>(R.id.tabLayout)
        tabLayout.setupWithViewPager(viewPager)
        tabLayout.tabMode = TabLayout.MODE_SCROLLABLE

    }
}