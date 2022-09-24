package com.example.islami

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.islami.fragments.HadethFragment
import com.example.islami.fragments.QuranFragment
import com.example.islami.fragments.RadioFragment
import com.example.islami.fragments.SebhaFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationBarView

class HomeActivity : AppCompatActivity() {

    lateinit var bottomNavigationBar: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        bottomNavigationBar = findViewById(R.id.botton_navigation_bar)

        bottomNavigationBar.selectedItemId = R.id.navigation_quran

        bottomNavigationBar.setOnItemSelectedListener(NavigationBarView.OnItemSelectedListener {

                menuItem ->

            if (menuItem.itemId == R.id.navigation_quran) {
                pushFragment(QuranFragment())

            } else if (menuItem.itemId == R.id.navigation_hadeth) {

                pushFragment(HadethFragment())

            } else if (menuItem.itemId == R.id.navigation_radio) {

                pushFragment(RadioFragment())

            } else if (menuItem.itemId == R.id.navigation_sebha) {
                pushFragment(SebhaFragment())

            }
            return@OnItemSelectedListener true;
        })

        bottomNavigationBar.selectedItemId = R.id.navigation_quran

    }

    private fun pushFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().replace(R.id.fragment_container, fragment)
            .commit()
    }
}