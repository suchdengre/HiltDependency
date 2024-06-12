package com.example.hiltpractice.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.hiltpractice.model.Product
import com.example.hiltpractice.model.ProductItem
import com.example.hiltpractice.repository.ProductRepository
import com.example.hiltpractice.utils.NetworkResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor (private val repository: ProductRepository) : ViewModel() {
   /* val productsLiveData : LiveData<List<ProductItem>>
        get() = repository.products

    *//*private val _products = MutableLiveData<NetworkResult<List<ProductItem>>>()
    val products: LiveData<NetworkResult<List<ProductItem>>>
        get() = _products*//*

    init {
        viewModelScope.launch {
            delay(10000)
            repository.getProducts()
        }
    }*/
    private val _products = MutableLiveData<NetworkResult<List<ProductItem>>>()
    val products: LiveData<NetworkResult<List<ProductItem>>>
        get() = _products

    fun getProducts(){
        viewModelScope.launch {
            val result = repository.getProducts()
            _products.postValue(result)
        }
    }
}