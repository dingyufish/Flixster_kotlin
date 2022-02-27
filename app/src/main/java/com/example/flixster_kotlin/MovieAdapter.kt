package com.example.flixster_kotlin

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide


private const val TAG = "MovieAdapter"
class MovieAdapter(private val context: Context, private val movies: List<Movie>):
    RecyclerView.Adapter<MovieAdapter.ViewHolder>() {

//Expensive opration: create a view
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        Log.i(TAG, "onCreateViewHolder")
        val view= LayoutInflater.from(context).inflate(R.layout.item_movie, parent, false)
        return ViewHolder(view)
    }

    //cheap : simply bind data to an exsting viewholder
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Log.i(TAG, "onBindViewHolder postion $position")
        val movie = movies[position]
        holder.bind(movie)
    }

    override fun getItemCount()= movies.size

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        private val tvTitle = itemView.findViewById<TextView>(R.id.tvTitle)
        private val tvOverview = itemView.findViewById<TextView>(R.id.tvOverview)
        private val ivPosterPath = itemView.findViewById<ImageView>(R.id.ivPosterpath)


        fun bind(movie:Movie){
            tvTitle.text = movie.title
            tvOverview.text = movie.overView
            Glide.with(context).load(movie.posterImageUrl).into(ivPosterPath)
        }
    }

}
