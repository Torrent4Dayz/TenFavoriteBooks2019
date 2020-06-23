package com.dicoding.picodiploma.tenfavoritebooks2019

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class GridBookAdapter(val listBook: ArrayList<Book>) : RecyclerView.Adapter<GridBookAdapter.GridViewHolder>(){
    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): GridBookAdapter.GridViewHolder {
        val view: View = LayoutInflater.from(viewGroup.context).inflate(R.layout.item_grid_hero, viewGroup, false)
        return GridViewHolder(view)
    }

    override fun onBindViewHolder(holder: GridBookAdapter.GridViewHolder, position: Int) {
        Glide.with(holder.itemView.context)
            .load(listBook[position].photo)
            .apply(RequestOptions().override(296,466))
            .into(holder.imgPhoto)
    }

    override fun getItemCount(): Int {
        return listBook.size
    }
    inner class GridViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        var imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)
    }
}