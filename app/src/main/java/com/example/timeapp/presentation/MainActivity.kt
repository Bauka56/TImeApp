package com.example.timeapp.presentation

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.timeapp.R
import com.google.android.material.bottomnavigation.BottomNavigationView
@Suppress("DEPRECATION")
class MainActivity : AppCompatActivity() {
    private lateinit var viewModel: MainViewModel
    private lateinit var countryListAdapter: CountryListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupRecyclerView()
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]
        viewModel.countryList.observe(this){
            countryListAdapter.submitList(it)
        }


        findViewById<BottomNavigationView>(R.id.btmNavView).setOnNavigationItemSelectedListener{
            when(it.itemId){
                R.id.miHome -> {}
                R.id.miAdd  -> {
                    val intent = CountryItemActivity.newIntentAddItem(this)
                    startActivity(intent)
                }
                R.id.miProfile ->{
                    val intent = Intent(this, OurTimeActivity::class.java)
                    startActivity(intent)
                    finish()
                }
            }
            true
        }
    }

    private fun setupRecyclerView() {
        val rvCountries = findViewById<RecyclerView>(R.id.rvCountries)
        countryListAdapter = CountryListAdapter()
        with(rvCountries) {
            adapter = countryListAdapter
            recycledViewPool.setMaxRecycledViews(
                R.layout.list_item,
                CountryListAdapter.MAX_POOL_SIZE)
        }
        //setupClickListener()
    }

    private fun setupClickListener() {
        countryListAdapter.onCountryItemClickListener = {
            Log.d("TouchElement", it.toString())
            val intent = CountryItemActivity.newIntentEditItem(this, it.id)
            startActivity(intent)
        }
    }

}