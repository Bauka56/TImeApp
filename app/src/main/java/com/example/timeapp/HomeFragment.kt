package com.example.timeapp

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.timeapp.databinding.FragmentHomeBinding

class HomeFragment : Fragment(R.layout.fragment_home) {

    private lateinit var bind:FragmentHomeBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind = FragmentHomeBinding.inflate(layoutInflater)


        val countryTimeList = mutableListOf<Country>(
        Country("New York", "US", "21:45"),
        Country("Ancara", "Turkey", "16:53"),
        Country("Astana", "KZ", "12:33"),
        Country("Rio", "Brazil", "13:45"),
        Country("Ulan Bator", "Mongolia", "18:12"),
        Country("Moon Real", "Canada", "15:12"),
        Country("Texas", "US", "20:35"),
        Country("Atyrau", "KZ", "10:33"),
        Country("Shymkent", "KZ", "12:33"),
        Country("Orynbor", "KZ", "11:33"),
        )



        val adapter = CountryAdapter(countryTimeList)
        bind.rvCountries.adapter = adapter
        bind.rvCountries.layoutManager = LinearLayoutManager(this.context)




        adapter.onItemClick = {
            val intent = Intent(this.context, DetailActivity::class.java)
            intent.putExtra("count", it)
            startActivity(intent)
        }

//        adapter.onItemClick = {
//            val bundle = Bundle()
//            bundle.putParcelableArrayList("countBund", ArrayList(countryTimeList))
//            val fragmentDetail = DetailFragment()
//            fragmentDetail.arguments = bundle
//        }


    }
}