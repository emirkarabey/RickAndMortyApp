package com.example.rickandmortyapp.ui
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.rickandmortyapp.R
import com.example.rickandmortyapp.adapter.LocationAdapter
import com.example.rickandmortyapp.viewmodel.LocationViewModel
import kotlinx.android.synthetic.main.activity_location.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.flow.collectLatest

class LocationActivity : AppCompatActivity() {
    lateinit var recyclerViewAdapter: LocationAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_location)

        initRecyclerView()
        initViewModel()
    }

    private fun initRecyclerView(){
        location_recycler_view.apply {
            layoutManager = LinearLayoutManager(this@LocationActivity)
            val decoration = DividerItemDecoration(applicationContext, DividerItemDecoration.VERTICAL)
            addItemDecoration(decoration)
            recyclerViewAdapter = LocationAdapter()
            adapter = recyclerViewAdapter
        }
    }
    private fun initViewModel(){
        val viewModel = ViewModelProvider(this).get(LocationViewModel::class.java)
        lifecycleScope.launchWhenCreated {
            viewModel.getListData().collectLatest {
                recyclerViewAdapter.submitData(it)
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater.inflate(R.menu.options_menu,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId == R.id.character){
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }
        else if(item.itemId == R.id.episode){
            val intent = Intent(this,EpisodeActivity::class.java)
            startActivity(intent)
        }else if(item.itemId == R.id.location){
        }
        return super.onOptionsItemSelected(item)
    }


}