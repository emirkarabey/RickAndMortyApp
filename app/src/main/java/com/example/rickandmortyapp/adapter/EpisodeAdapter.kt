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
import com.example.rickandmortyapp.model.EpisodeData

class EpisodeAdapter:PagingDataAdapter<EpisodeData, EpisodeAdapter.EpisodeViewHolder>(DiffUtilCallBack()) {

    class EpisodeViewHolder(view: View):RecyclerView.ViewHolder(view){
        val e_name: TextView = view.findViewById(R.id.e_name)
        val e_episode = view.findViewById<TextView>(R.id.e_episode)
        val episode_imageView: ImageView = view.findViewById(R.id.episode_imageView)

        fun bind(data:EpisodeData) {
            e_name.text = data.name
            e_episode.text = data.episode

            Glide.with(episode_imageView)
                .load(R.drawable.rickmortyepisode)
                .circleCrop()
                .into(episode_imageView)
        }
    }

    private class DiffUtilCallBack : DiffUtil.ItemCallback<EpisodeData>() {
        override fun areItemsTheSame(oldItem: EpisodeData, newItem: EpisodeData): Boolean {
            return oldItem.name == newItem.name
        }

        override fun areContentsTheSame(oldItem: EpisodeData, newItem: EpisodeData): Boolean {
            return oldItem.name == newItem.name
                    &&oldItem.episode == newItem.episode
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EpisodeViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.episode_recycler_row,parent,false)
        return EpisodeViewHolder(view)
    }

    override fun onBindViewHolder(holder: EpisodeViewHolder, position: Int) {
        holder.bind(getItem(position)!!)

    }
}