package com.example.myfirstapp.main

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.myfirstapp.main.FragmentOne
import com.example.myfirstapp.main.FragmentThree
import com.example.myfirstapp.main.FragmentTwo


class MainViewPagerAdapter (fm : FragmentManager): FragmentPagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT){

    override fun getItem(position: Int): Fragment {
        return when(position){
            0 -> FragmentOne()
            1 -> FragmentTwo()
            else -> FragmentThree()
        }

    }

    override fun getCount() = 3
}