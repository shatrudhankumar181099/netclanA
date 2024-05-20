package com.shatrudhan.netclan.REFINE

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.shatrudhan.netclan.Explore.ExploreScreen
import com.shatrudhan.netclan.R
import com.shatrudhan.netclan.databinding.ActivityRefineScreenBinding

class RefineScreen : AppCompatActivity() {
    lateinit var addFAB: FloatingActionButton
    private var binding : ActivityRefineScreenBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRefineScreenBinding.inflate(layoutInflater)
        setContentView(binding!!.root)
        addFAB = findViewById(R.id.idFABaDDnOTE)

        val fragmentArrayList = ArrayList<Fragment>()
        fragmentArrayList.add(PersonalFragment())
        fragmentArrayList.add(BusinessFragment())
        fragmentArrayList.add(MerchantFragment())
        val adapter = ViewPagerAdapter(this, supportFragmentManager, fragmentArrayList)
        binding!!.viewpager.adapter = adapter

        binding!!.Tab.setupWithViewPager(binding!!.viewpager)
        addFAB.setOnClickListener {
            val intent = Intent(this@RefineScreen, ExploreScreen::class.java)
            startActivity(intent)
            this.finish()
        }



    }
}