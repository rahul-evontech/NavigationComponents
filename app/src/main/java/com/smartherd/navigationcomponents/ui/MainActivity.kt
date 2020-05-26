package com.smartherd.navigationcomponents.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.smartherd.navigationcomponents.R
import com.smartherd.navigationcomponents.ViewModel.MovieViewModel
import com.smartherd.navigationcomponents.ViewModel.MovieViewModelFactory
import com.smartherd.navigationcomponents.dataSource.MoviePageListRepository
import com.smartherd.navigationcomponents.network.Api
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.appbar.*


class MainActivity : AppCompatActivity() {

    lateinit var viewModel: MovieViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val api = Api.invoke()
        val repository = MoviePageListRepository(api)
        val factory = MovieViewModelFactory(repository)

        viewModel = ViewModelProvider(this,factory).get(MovieViewModel::class.java)

        setSupportActionBar(toolbar)



        val drawerLayout = findViewById<DrawerLayout>(R.id.drawerLayout)
        val navController = this.findNavController(R.id.fragment)

        NavigationUI.setupWithNavController(navView,navController)

        NavigationUI.setupActionBarWithNavController(this,navController,drawerLayout)



    }

    override fun onSupportNavigateUp(): Boolean {
        return NavigationUI.navigateUp(this.findNavController(R.id.fragment),drawerLayout)
    }


}
