package com.example.hiltpractice.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class ProductItem(
    val category: String,
    val description: String,

    @PrimaryKey(autoGenerate = false)
    val id: Int,

    val image: String,
    val price: Double,
    val title: String
)