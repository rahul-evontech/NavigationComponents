package com.smartherd.movieapp.data.movie


import com.google.gson.annotations.SerializedName

data class Results(
    @SerializedName("popularity")
    val popularity: Double = 0.0,
    @SerializedName("vote_count")
    val voteCount: Int = 0,
    @SerializedName("video")
    val video: Boolean = false,
    @SerializedName("poster_path")
    val posterPath: String = "",
    @SerializedName("id")
    val id: Int = 0,
    @SerializedName("adult")
    val adult: Boolean = false,
    @SerializedName("backdrop_path")
    val backdropPath: String = "",
    @SerializedName("original_language")
    val originalLanguage: String = "",
    @SerializedName("original_title")
    val originalTitle: String = "",
    @SerializedName("genre_ids")
    val genreIds: List<Int> = listOf(),
    @SerializedName("title")
    val title: String = "",
    @SerializedName("vote_average")
    val rating: Float,
    @SerializedName("overview")
    val overview: String = "",
    @SerializedName("release_date")
    val releaseDate: String = ""
)