package com.example.hiltpractice.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.hiltpractice.model.Product
import com.example.hiltpractice.model.ProductItem

@Database(entities = [ProductItem::class], version = 1)
abstract class ProductDb : RoomDatabase(){

    abstract fun getProductDAO() : ProductDao

}