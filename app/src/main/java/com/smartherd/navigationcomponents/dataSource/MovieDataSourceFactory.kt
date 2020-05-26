package com.smartherd.navigationcomponents.dataSource

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import androidx.paging.PageKeyedDataSource
import com.smartherd.movieapp.data.movie.Results
import com.smartherd.navigationcomponents.network.Api
import kotlinx.coroutines.CoroutineScope

class MovieDataSourceFactory(val api: Api,
                             val scope: CoroutineScope,
                             val category: String
): DataSource.Factory<Int,Results>() {

    val movieLiveDataSource = MutableLiveData<MovieDataSource>()


    override fun create(): DataSource<Int, Results> {
        val movieDataSource = MovieDataSource(api,scope,category)
        Log.e("Error","Movie Live Data Source: $movieLiveDataSource")
        movieLiveDataSource.postValue(movieDataSource)
        return movieDataSource
    }
}