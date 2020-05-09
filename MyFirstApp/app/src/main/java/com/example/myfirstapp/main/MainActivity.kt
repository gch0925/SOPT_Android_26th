package com.example.myfirstapp.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager.widget.ViewPager
import kotlinx.android.synthetic.main.activity_main.*
import android.widget.EditText
import com.example.myfirstapp.R

class MainActivity : AppCompatActivity() {

    private lateinit var  et_email : EditText
    private lateinit var  et_pw : EditText


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        vp_main.adapter =
            MainViewPagerAdapter(
                supportFragmentManager
            )
        vp_main.offscreenPageLimit = 2
        vp_main.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrollStateChanged(state: Int) {
            }

            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
            }

            override fun onPageSelected(position: Int) {
                bnv_main.menu.getItem(position).isChecked = true
            }
        })


        bnv_main.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.menu_one -> vp_main.currentItem = 0
                R.id.menu_two -> vp_main.currentItem = 1
                R.id.menu_three -> vp_main.currentItem = 2
            }
            true
        }
    }
}