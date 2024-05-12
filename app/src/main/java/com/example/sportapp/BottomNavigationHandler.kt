package com.example.sportapp

import android.content.Context
import android.content.Intent
import com.google.android.material.bottomnavigation.BottomNavigationView


object BottomNavigationHandler {
    fun setupBottomNavigation(bottomNavigationView: BottomNavigationView,
                              context: Context, ) {
        bottomNavigationView.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigation_messages -> {
                    true
                }
                R.id.navigation_news -> {
                    val intent = Intent(context, News::class.java)
                    context.startActivity(intent)

                    true
                }
                R.id.navigation_cart -> {
                    true
                }
                R.id.navigation_profile -> {
                    val intent = Intent(context, MyProfile::class.java)
                    context.startActivity(intent)

                    true
                }
                // Добавьте обработку других элементов навигации здесь, если нужно
                else -> false
            }
        }
    }
}

