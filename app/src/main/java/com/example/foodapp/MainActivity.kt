package com.example.foodapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {

    private lateinit var viewPager: ViewPager2
    private lateinit var tabLayout: TabLayout
    private lateinit var bottomNavigationView: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewPager = findViewById(R.id.viewPager)
        tabLayout = findViewById(R.id.tabLayout)
        bottomNavigationView = findViewById(R.id.bottom_navigation)

        bottomNavigationView.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_recipes, R.id.nav_meal_planner, R.id.nav_blog, R.id.nav_contact, R.id.nav_about_me -> setupViewPager()
            }
            true
        }
        bottomNavigationView.selectedItemId = R.id.nav_recipes
    }

    private fun setupViewPager() {
        val adapter = ViewPagerAdapter(this).apply {
            addFragment(RecipesFragment(), "Recipes")
            addFragment(MealPlannerFragment(), "Meal Planner")
            addFragment(BlogFragment(), "Blog")
            addFragment(ContactFragment(), "Contact")
            addFragment(AboutMeFragment(), "About Me")
        }
        viewPager.adapter = adapter
        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.text = adapter.getPageTitle(position)
        }.attach()
    }

    inner class ViewPagerAdapter(fa: FragmentActivity) : FragmentStateAdapter(fa) {
        private val fragmentList = ArrayList<Fragment>()
        private val fragmentTitleList = ArrayList<String>()

        fun addFragment(fragment: Fragment, title: String) {
            fragmentList.add(fragment)
            fragmentTitleList.add(title)
        }

        override fun createFragment(position: Int): Fragment {
            return fragmentList[position]
        }

        override fun getItemCount(): Int = fragmentList.size

        fun getPageTitle(position: Int): CharSequence = fragmentTitleList[position]
    }
}



