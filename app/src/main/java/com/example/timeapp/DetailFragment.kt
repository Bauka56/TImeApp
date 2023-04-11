package com.example.timeapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.timeapp.databinding.FragmentDetailBinding

@Suppress("DEPRECATION")
class DetailFragment : Fragment(R.layout.fragment_detail) {

    private lateinit var bind:FragmentDetailBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        val bundle = arguments
        val countryList = bundle?.getParcelableArrayList<Country>("countBund")
        if(countryList != null){
            var cityDetail: TextView = bind.tvDetailCity
            var countryDetail: TextView = bind.tvDetailCountry
            var timeDetail: TextView = bind.tvDetailTime

            val recyclerView = view?.findViewById<RecyclerView>(R.id.rvCountries)
            val adapter = CountryAdapter(countryList)
            recyclerView?.adapter = adapter
            recyclerView?.layoutManager = LinearLayoutManager(requireContext())

        }


    }
}