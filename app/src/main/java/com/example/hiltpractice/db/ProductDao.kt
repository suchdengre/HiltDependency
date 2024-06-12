package com.example.hiltpractice.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.hiltpractice.model.ProductItem

@Dao
interface ProductDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addProduct(product : List<ProductItem>)

   @Query("SELECT * FROM  ProductItem")
    suspend fun getProducts() : List<ProductItem>
}