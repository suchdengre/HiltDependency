package com.example.hiltpractice.api

import com.example.hiltpractice.model.ProductItem
import retrofit2.Response
import retrofit2.http.GET

interface ProductApi {

    @GET("products")
    suspend fun getProducts() : Response<List<ProductItem>>
}