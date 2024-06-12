package com.example.hiltpractice.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView

import androidx.recyclerview.widget.RecyclerView
import com.example.hiltpractice.model.ProductItem
import com.bumptech.glide.Glide
import com.example.hiltpractice.R

class ProductAdapter(private val productList:List<ProductItem>):
    RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ProductAdapter.ProductViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.product_item, parent, false)
        return ProductViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProductAdapter.ProductViewHolder, position: Int) {
        val product = productList[position]
        holder.name.text = product.title
        Glide.with(holder.image.context).load(product.image).into(holder.image)
    }

    override fun getItemCount(): Int {
        return productList.size
    }

    class ProductViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val image = itemView.findViewById<ImageView>(R.id.productImage)
        val name = itemView.findViewById<TextView>(R.id.productName)

    }
}


