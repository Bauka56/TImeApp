package com.example.timeapp.presentation

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.timeapp.R

@Suppress("DEPRECATION")
class LoadScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_load_screen)

        Toast.makeText(this,"Please wait, app is running...", Toast.LENGTH_SHORT).show()

        Handler().postDelayed({
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }, 4000L)
    }
}