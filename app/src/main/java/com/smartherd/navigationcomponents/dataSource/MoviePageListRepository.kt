package com.smartherd.navigationcomponents.dataSource

import androidx.lifecycle.LiveData
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.smartherd.movieapp.data.movie.Results
import com.smartherd.navigationcomponents.network.Api
import kotlinx.coroutines.CoroutineScope

class MoviePageListRepository(
    val api: Api
) {

    lateinit var moviePageList : LiveData<PagedList<Results>>
    lateinit var movieDataSourceFactory: MovieDataSourceFactory

    fun fetchMovie(path: String,scope: CoroutineScope): LiveData<PagedList<Results>> {

        movieDataSourceFactory = MovieDataSourceFactory(api,scope,path)

        val config = PagedList.Config.Builder()
            .setPageSize(20)
            .setEnablePlaceholders(false)
            .build()

        moviePageList = LivePagedListBuilder(movieDataSourceFactory,config).build()

        return moviePageList
    }
}