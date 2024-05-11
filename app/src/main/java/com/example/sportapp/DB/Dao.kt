package com.example.sportapp.DB

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface Dao {
    @Insert
    fun insertItem(item: Item)
    @Query("SELECT * FROM items")
    fun getData(): List<Item>
}