package com.smartherd.navigationcomponents.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.smartherd.movieapp.data.movie.Results
import com.smartherd.navigationcomponents.dataSource.MoviePageListRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job

class MovieViewModel(
    val repository: MoviePageListRepository
): ViewModel() {

    val job = Job()
    val scope = CoroutineScope(Dispatchers.Main + job)


    fun  getMovies(category: String): LiveData<PagedList<Results>> {
        return repository.fetchMovie(category,scope)
    }

    override fun onCleared() {
        super.onCleared()
        job.cancel()
    }

}