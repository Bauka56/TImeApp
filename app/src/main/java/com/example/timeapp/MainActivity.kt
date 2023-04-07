package com.example.timeapp

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.timeapp.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

@Suppress("DEPRECATION")
class MainActivity : AppCompatActivity() {


   private lateinit var countryAdapter: CountryAdapter

    private lateinit var countryTimeList: ArrayList<Country>

    private lateinit var recyclerView:RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.rvCountries)
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(this)


        countryTimeList = ArrayList()

            countryTimeList.add(Country("New York", "US", "21:45"))
            countryTimeList.add(Country("Ancara", "Turkey", "16:53"))
            countryTimeList.add(Country("Astana", "KZ", "12:33"))
            countryTimeList.add(Country("Rio", "Brazil", "13:45"))
            countryTimeList.add(Country("Ulan Bator", "Mongolia", "18:12"))
            countryTimeList.add(Country("Moon Real", "Canada", "15:12"))
            countryTimeList.add(Country("Texas", "US", "20:35"))
            countryTimeList.add(Country("Atyrau", "KZ", "10:33"))
            countryTimeList.add(Country("Shymkent", "KZ", "12:33"))
            countryTimeList.add(Country("Orynbor", "KZ", "11:33"))


        countryAdapter = CountryAdapter(countryTimeList)
        recyclerView.adapter = countryAdapter


        countryAdapter.onItemClick = {
            val intent = Intent(this, DetailActivity::class.java)
            intent.putExtra("count", it)
            startActivity(intent)
        }

        findViewById<BottomNavigationView>(R.id.btmNavView).setOnNavigationItemSelectedListener{
            when(it.itemId){
                R.id.miHome -> {}
                R.id.miProfile ->{
                    val intent = Intent(this, OurTimeActivity::class.java)
                    startActivity(intent)
                }
            }
            true
        }

    }

}