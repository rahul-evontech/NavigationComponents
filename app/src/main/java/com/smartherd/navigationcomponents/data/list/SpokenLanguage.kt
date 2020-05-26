package com.smartherd.movieapp.data.list


import com.google.gson.annotations.SerializedName

data class SpokenLanguage(
    @SerializedName("iso_639_1")
    val iso6391: String = "",
    @SerializedName("name")
    val name: String = ""
)