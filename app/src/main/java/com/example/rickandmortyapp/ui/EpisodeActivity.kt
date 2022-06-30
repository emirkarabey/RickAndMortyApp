package com.example.rickandmortyapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.rickandmortyapp.R
import com.example.rickandmortyapp.adapter.CharacterAdapter
import com.example.rickandmortyapp.adapter.EpisodeAdapter
import com.example.rickandmortyapp.viewmodel.CharacterViewModel
import com.example.rickandmortyapp.viewmodel.EpisodeViewModel
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.flow.collectLatest

class EpisodeActivity : AppCompatActivity() {
    lateinit var recyclerViewAdapter: EpisodeAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_episode)
        initRecyclerView()
        initViewModel()
    }

    private fun initRecyclerView(){
        recycler_view.apply {
            layoutManager = LinearLayoutManager(this@EpisodeActivity)
            val decoration = DividerItemDecoration(applicationContext, DividerItemDecoration.VERTICAL)
            addItemDecoration(decoration)
            recyclerViewAdapter = EpisodeAdapter()
            adapter = recyclerViewAdapter
        }
    }
    private fun initViewModel(){
        val viewModel = ViewModelProvider(this).get(EpisodeViewModel::class.java)
        lifecycleScope.launchWhenCreated {
            viewModel.getListData().collectLatest {
                recyclerViewAdapter.submitData(it)
            }
        }
    }
}