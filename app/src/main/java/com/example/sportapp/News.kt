package com.example.sportapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView

class News : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news)

        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.button_navigation)
        BottomNavigationHandler.setupBottomNavigation(bottomNavigationView, this)
    }

}