package com.example.rickandmortyapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.rickandmortyapp.R
import com.example.rickandmortyapp.model.LocationData

class LocationAdapter : PagingDataAdapter<LocationData, LocationAdapter.LocationViewHolder>(DiffUtilCallBack()) {

    class LocationViewHolder(view: View): RecyclerView.ViewHolder(view){
        val l_name: TextView = view.findViewById(R.id.l_name)
        val l_type = view.findViewById<TextView>(R.id.l_type)
        val location_imageView: ImageView = view.findViewById(R.id.location_imageView)

        fun bind(data: LocationData) {
            l_name.text = data.name
            l_type.text = data.type

            Glide.with(location_imageView)
                .load(R.drawable.rickandmortyplanet)
                .circleCrop()
                .into(location_imageView)
        }

    }

    private class DiffUtilCallBack : DiffUtil.ItemCallback<LocationData>() {
        override fun areItemsTheSame(oldItem: LocationData, newItem: LocationData): Boolean {
            return oldItem.name == newItem.name
        }

        override fun areContentsTheSame(oldItem: LocationData, newItem: LocationData): Boolean {
            return oldItem.name == newItem.name
                    &&oldItem.type == newItem.type
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LocationViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.location_recycler_row,parent,false)
        return LocationViewHolder(view)
    }

    override fun onBindViewHolder(holder: LocationViewHolder, position: Int) {
        holder.bind(getItem(position)!!)

    }
}