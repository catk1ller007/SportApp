package com.example.sportapp

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView


class MyProfile : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_profile)

        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.button_navigation)
        BottomNavigationHandler.setupBottomNavigation(bottomNavigationView)

        val nickame = intent.getStringExtra("NICKNAME_EXTRA")
        val login = intent.getStringExtra("LOGIN_EXTRA")

        val fioTextView = findViewById<TextView>(R.id.FIO)
        fioTextView.text = "ФИО: $nickame"

        val logiTextView = findViewById<TextView>(R.id.LOGIN)
        logiTextView.text = "Почта: $login"
    }
}
