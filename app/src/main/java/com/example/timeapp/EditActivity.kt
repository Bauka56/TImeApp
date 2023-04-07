package com.example.timeapp

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcelable
import android.widget.Button
import android.widget.TextView

class EditActivity : AppCompatActivity() {

    private lateinit var btnEditApply: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit)

        var countryD = intent.getParcelableExtra<Country>("count")
        if (countryD != null) {
            var cityEdit: TextView = findViewById(R.id.etEditCity)
            var countryEdit: TextView = findViewById(R.id.etEditCountry)
            var timeEdit: TextView = findViewById(R.id.etEditTime)

            cityEdit.text = countryD.nameCity
            countryEdit.text = countryD.nameCountry
            timeEdit.text = countryD.countryTime
        }

        btnEditApply = findViewById(R.id.btnEditApply)

        btnEditApply.setOnClickListener{

        }
    }
}