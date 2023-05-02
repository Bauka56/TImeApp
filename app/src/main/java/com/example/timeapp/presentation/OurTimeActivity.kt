package com.example.timeapp.presentation

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.timeapp.R
import com.google.android.material.bottomnavigation.BottomNavigationView

@Suppress("DEPRECATION")
class OurTimeActivity : AppCompatActivity(){

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_our_time)

        findViewById<BottomNavigationView>(R.id.btmNavOur).setOnNavigationItemSelectedListener{
            when(it.itemId){
                R.id.miHome -> {
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                    finish()
                }
                R.id.miAdd  -> {
                    val intent = CountryItemActivity.newIntentAddItem(this)
                    startActivity(intent)
                }
                R.id.miProfile ->{
                }
            }
            true
        }

    }
}