package com.example.sportapp

import com.google.android.material.bottomnavigation.BottomNavigationView


object BottomNavigationHandler {
    fun setupBottomNavigation(bottomNavigationView: BottomNavigationView) {
        bottomNavigationView.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigation_messages -> {
                    true
                }
                R.id.navigation_news -> {
                    // Обработка нажатия на элемент новостей
                    true
                }
                R.id.navigation_mail -> {
                    true
                }
                R.id.navigation_profile -> {
                    true
                }
                // Добавьте обработку других элементов навигации здесь, если нужно
                else -> false
            }
        }
    }
}

