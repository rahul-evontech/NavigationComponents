package com.smartherd.navigationcomponents.ui.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import com.smartherd.navigationcomponents.R
import com.smartherd.navigationcomponents.ViewModel.MovieViewModel
import com.smartherd.navigationcomponents.adapter.MoviesPagedListAdapter
import com.smartherd.navigationcomponents.ui.MainActivity
import kotlinx.android.synthetic.main.fragment_top_rated.*

/**
 * A simple [Fragment] subclass.
 */
class TopRated : Fragment() {

    lateinit var viewModel: MovieViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_top_rated, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = (activity as MainActivity).viewModel

        val category = "top_rated"

        val moviesAdapter = MoviesPagedListAdapter(requireContext())
        recyclerViewTopRated.apply {
            layoutManager = GridLayoutManager(context, 3)
            adapter = moviesAdapter
        }

        viewModel.getMovies(category).observe(viewLifecycleOwner, Observer {
            moviesAdapter.submitList(it)
            Log.e("error","top Rated")
        })
    }


}
