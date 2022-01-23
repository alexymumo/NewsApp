package com.example.newsapp.ui.adapters

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.newsapp.ui.fragments.ArticleFragment
import com.example.newsapp.ui.fragments.SportsFragment
import com.example.newsapp.ui.fragments.TechFragment
import com.example.newsapp.ui.fragments.TrendingFragment

class ViewPagerAdapter(
    fm: androidx.fragment.app.FragmentManager?,
    private val Head_Titles: Array<CharSequence>,
    private val totalTabs: Int) : FragmentStateAdapter(fm!!) {

    override fun getItem(position: Int): Fragment? {
        when(position) {
            0 -> {
                return ArticleFragment()
            }
            1 -> {
                return TrendingFragment()
            }
            2 -> {
                return SportsFragment()
            }
            else -> return null
        }

    }

    override fun getTitle(position: Int) : CharSequence? {
        return Head_Titles[position]
    }

    override fun getCount(): Int {
        return totalTabs
    }


    init {
        totalTabs = totalTabs
    }
}