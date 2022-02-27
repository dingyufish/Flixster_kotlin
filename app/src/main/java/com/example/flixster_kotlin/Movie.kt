package com.example.flixster_kotlin

import org.json.JSONArray

//repersent one movie abject to define the data
data class Movie (
    val movieId: Int,
    private val posterPath: String,
    val title: String,
    val overView: String,
        ){
    val posterImageUrl = "https://image.tmdb.org/t/p/w342/$posterPath"
    companion object{

         //call methoe on the the moive class
        fun fromJsonArray(movieJsonArray: JSONArray):List<Movie> {
            val movies = mutableListOf<Movie>()
            for (i in 0 until movieJsonArray.length() ){
                val movieJson = movieJsonArray. getJSONObject(i)
                movies.add(
                    Movie(
                        movieJson.getInt("id"),
                        movieJson.getString("poster_path"),
                        movieJson.getString("title"),
                        movieJson.getString("overview")
                    )
                )

            }
             return movies
        }

    }
}