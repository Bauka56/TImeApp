package com.example.timeapp.domain

data class CountryItem(
    var cityName: String,
    var countryName: String,
    var timeWorld: String,
    var id: Int = UNDEFINED_ID
) {


    companion object{
        const val UNDEFINED_ID = -1
    }
}
