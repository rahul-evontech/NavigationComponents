package com.smartherd.navigationcomponents.dataSource

import android.util.Log
import androidx.paging.PageKeyedDataSource
import com.smartherd.movieapp.data.movie.Results
import com.smartherd.navigationcomponents.Utils.Resource
import com.smartherd.navigationcomponents.network.Api
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

class MovieDataSource(
    val api: Api,
    val scope: CoroutineScope,
    val category: String
): PageKeyedDataSource<Int, Results>(){

    private var page = 1

    override fun loadInitial(
        params: LoadInitialParams<Int>,
        callback: LoadInitialCallback<Int, Results>
    ) {
        scope.launch {
            val response = api.getMovies(category,page)
            if(response.isSuccessful){
                callback.onResult(response.body()!!.results,null,page + 1)
            }else{
                Log.e("Error","Error Message:  ${response.message()}")
            }
        }
    }

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, Results>) {

        scope.launch {
            val response = api.getMovies(category,params.key)
            if(response.isSuccessful && (params.key < response.body()!!.totalPages)){
                callback.onResult(response.body()!!.results,params.key + 1)
            }else{
                Log.e("Error","Error Message: ${response.message()}")
            }
        }
    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, Results>) {

        }
}