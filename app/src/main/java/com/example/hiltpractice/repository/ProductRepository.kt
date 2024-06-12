package com.example.hiltpractice.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.hiltpractice.api.ProductApi
import com.example.hiltpractice.db.ProductDb
import com.example.hiltpractice.model.Product
import com.example.hiltpractice.model.ProductItem
import com.example.hiltpractice.utils.NetworkResult
import javax.inject.Inject

class ProductRepository @Inject constructor(private val productApi: ProductApi,private val productDb: ProductDb) {
   /* private val _products = MutableLiveData<List<ProductItem>>()
    val products: LiveData<List<ProductItem>>
        get() = _products

    suspend fun getProducts(){
        val result = productApi.getProducts()
        if(result.isSuccessful && result.body() != null){
            productDb.getProductDAO().addProduct(result.body()!!)
            _products.postValue(result.body())
        }
    }*/
   suspend fun getProducts(): NetworkResult<List<ProductItem>> {
       val response = productApi.getProducts()
       return if (response.isSuccessful) {
           val responseBody = response.body()
           if (responseBody != null) {
               NetworkResult.Success(responseBody)
           } else {
               NetworkResult.Error("Something went wrong")
           }
       } else {
           NetworkResult.Error("Something went wrong")
       }

   }
}