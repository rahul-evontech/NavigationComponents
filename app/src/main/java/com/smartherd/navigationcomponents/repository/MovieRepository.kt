package com.smartherd.navigationcomponents.repository

import com.smartherd.navigationcomponents.network.Api

class MovieRepository(
    val api : Api
) {

    suspend fun getMovieId(id: Int) = api.getMovieId(id)

}