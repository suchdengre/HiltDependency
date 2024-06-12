package com.example.hiltpractice

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.hiltpractice.adapter.ProductAdapter
import com.example.hiltpractice.utils.NetworkResult
import com.example.hiltpractice.viewmodel.MainViewModel
import com.example.hiltpractice.viewmodel.MainViewModelFactory

import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint

class MainActivity : AppCompatActivity() {
    lateinit var recyclerView: RecyclerView
    lateinit var adapter: ProductAdapter
    val mainViewModel: MainViewModel by viewModels()
   // lateinit var  mainViewModel: MainViewModel
    private val products: TextView
        get() = findViewById(R.id.productName)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        recyclerView = findViewById(R.id.productList)
        recyclerView.layoutManager = GridLayoutManager(this,2)

        /*val repository = (application as StoreApplication).productRepository
        mainViewModel = ViewModelProvider(this,MainViewModelFactory(repository))
            .get(MainViewModel::class.java)*/

        mainViewModel.getProducts()

        mainViewModel.products.observe(this, Observer {
            when(it){
                is NetworkResult.Success -> {
                    Log.d("Data",it.data.toString())
                    adapter = ProductAdapter(it.data!!)
                    recyclerView.adapter = adapter
                }
                is NetworkResult.Error -> {}
                is NetworkResult.Loading -> {}
            }
        })

       /* mainViewModel = ViewModelProvider(this)
            .get(MainViewModel::class.java)*/



      /*  mainViewModel.productsLiveData.observe(this, Observer {
            products.text =  it.joinToString { x -> x.title + "\n\n" }
        })*/
    }

    }
