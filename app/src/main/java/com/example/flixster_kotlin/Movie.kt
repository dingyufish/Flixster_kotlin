package com.example.flixster_kotlin

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import kotlinx.parcelize.IgnoredOnParcel
import org.json.JSONArray

@Parcelize

//repersent one movie abject to define the data
data class Movie (
    val movieId: Int,
    val voteAverage: Double,
    private val posterPath: String,
    val title: String,
    val overView: String, ):Parcelable
{
    @IgnoredOnParcel
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
                        movieJson.getDouble("vote_average"),
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