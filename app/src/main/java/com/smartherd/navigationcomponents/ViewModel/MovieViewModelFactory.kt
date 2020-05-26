package com.smartherd.navigationcomponents.ViewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.smartherd.navigationcomponents.dataSource.MoviePageListRepository

class MovieViewModelFactory(
    val respository: MoviePageListRepository
): ViewModelProvider.Factory{

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MovieViewModel(
            respository
        ) as T
    }
}