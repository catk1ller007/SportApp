package com.example.sportapp.DB

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity (tableName = "items")
data class Item(
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null,
    @ColumnInfo(name =  "Name")
    var  name: String,
    @ColumnInfo(name =  "Email")
    var  email: String,
    @ColumnInfo(name =  "Password")
    var  password: String,
)
