package com.example.nearestridemap

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2
import com.example.nearestridemap.Adapter.PagerAdapter
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var tabtitle= arrayOf("Nearest","Upcoming","Past","Filter")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val t=findViewById<TabLayout>(R.id.tabLayout)
        val pager=findViewById<ViewPager2>(R.id.viewPager2)
        viewPager2.adapter= PagerAdapter(supportFragmentManager,lifecycle)
        TabLayoutMediator(t,pager){
            tab,position->
            tab.text=tabtitle[position]
        }.attach()
    }
}