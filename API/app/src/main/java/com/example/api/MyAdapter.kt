package com.example.api

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RatingBar
import android.widget.TextView
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView
import com.squareup.picasso.Picasso

class MyAdapter(val context : Activity, val productArrayList : List<Product>) :
    RecyclerView.Adapter<MyAdapter.MyViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(context).inflate(R.layout.eachitem, parent, false)
        return MyViewHolder(itemView)
    }

    override fun getItemCount(): Int {
       return productArrayList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = productArrayList[position]
        holder.title.text = currentItem.title
        holder.rating.rating = currentItem.rating
        //imageview , how to show image in imageview if image is a URL, uses 3rd party library
        //picasso
        Picasso.get().load(currentItem.thumbnail).into(holder.image);
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var title : TextView
        var image : ShapeableImageView
        var rating : RatingBar

        init {
            title = itemView.findViewById(R.id.productname)
            rating = itemView.findViewById(R.id.ratingBar)
            image  = itemView.findViewById(R.id.productImage)
        }
    }

}