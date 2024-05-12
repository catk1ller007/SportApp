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
    @Query("SELECT * FROM items WHERE Email = :login AND Password = :password")
    fun getUserByLoginAndPassword(login: String, password: String): Item?
}