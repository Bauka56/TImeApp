package com.example.timeapp

import android.content.Intent
import android.os.Build.VERSION.SDK_INT
import android.os.Bundle
import android.os.Parcelable
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity



class DetailActivity : AppCompatActivity() {

    inline fun <reified T : Parcelable> Intent.parcelable(key: String): T? = when {
        SDK_INT >= 33 -> getParcelableExtra(key, T::class.java)
        else -> @Suppress("DEPRECATION") getParcelableExtra(key) as? T
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detailed)

        var countryD = intent.getParcelableExtra<Country>("count")
        if (countryD != null) {
            var cityDetail: TextView = findViewById(R.id.tvDetailCity)
            var countryDetail: TextView = findViewById(R.id.tvDetailCountry)
            var timeDetail: TextView = findViewById(R.id.tvDetailTime)

            cityDetail.text = countryD.nameCity
            countryDetail.text = countryD.nameCountry
            timeDetail.text = countryD.countryTime
        }

    }
}