package com.example.timeapp

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.timeapp.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

@Suppress("DEPRECATION")
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val homeFragment = HomeFragment()
        val profileFragment = ProfileFragment()

        supportFragmentManager.beginTransaction().add(R.id.flFragment, homeFragment).commit()

        findViewById<BottomNavigationView>(R.id.btmNavView).setOnNavigationItemSelectedListener{
            when(it.itemId){
                R.id.miHome -> setCurrentFragment(homeFragment)
                R.id.miProfile ->setCurrentFragment(profileFragment)
            }
            true
        }

    }
    private fun setCurrentFragment(fragment: Fragment){
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.flFragment, fragment)
            commit()
        }
    }


}