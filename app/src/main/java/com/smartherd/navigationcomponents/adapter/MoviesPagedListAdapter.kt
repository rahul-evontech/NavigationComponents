package com.smartherd.navigationcomponents.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.smartherd.movieapp.data.movie.Results
import com.smartherd.navigationcomponents.R
import kotlinx.android.synthetic.main.list_item.view.*

class MoviesPagedListAdapter(
  val  context: Context
): PagedListAdapter<Results,MoviesPagedListAdapter.ViewHolder>(DiffUtilCallback()){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item,
            parent,
        false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)

        holder.bindUI(item,context)
    }

    class DiffUtilCallback: DiffUtil.ItemCallback<Results>(){
        override fun areItemsTheSame(oldItem: Results, newItem: Results): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Results, newItem: Results): Boolean {
            return oldItem == newItem
        }
    }


    class ViewHolder(view: View): RecyclerView.ViewHolder(view){


            fun bindUI(item: Results?,context: Context){
                val moviePosterUrl =  "https://image.tmdb.org/t/p/w342" + item?.posterPath
                Glide.with(itemView.context)
                    .load(moviePosterUrl)
                    .into(itemView.imageView)

                itemView.cv_movie_release_date.text = item?.releaseDate
                itemView.cv_movie_title.text = item?.title

            }

    }
}