package com.example.onlineoffline

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val mainViewModel: MainViewModel = ViewModelProvider(this, MainViewModelProvider(PhotoRepository(ApiServiceProvider.apiService, AppDatabase.getInstance(applicationContext).photoDao())))[MainViewModel::class.java]

        mainViewModel.photoLiveData.observe(this, Observer {
            val recyclerView: RecyclerView = findViewById(R.id.rv_main)
            val photoAdapter = PhotoAdapter(it)
            recyclerView.layoutManager =
                LinearLayoutManager(this@MainActivity, LinearLayoutManager.VERTICAL, false)
            recyclerView.adapter = photoAdapter
        })

        mainViewModel.errorLiveData.observe(this, Observer {
            Toast.makeText(this@MainActivity, "Error : $it", Toast.LENGTH_LONG).show()
        })
    }
}




















/**/

/*
        mainViewModel.getPhotos().observe(this, Observer {
            val recyclerView: RecyclerView = findViewById(R.id.rv_main)
            val photoAdapter = PhotoAdapter(it)
            recyclerView.layoutManager =
                LinearLayoutManager(this@MainActivity, LinearLayoutManager.VERTICAL, false)
            recyclerView.adapter = photoAdapter
        })
        mainViewModel.errorLiveData.observe(this, Observer {
            Toast.makeText(this@MainActivity, "Error : $it", Toast.LENGTH_LONG).show()
        })

        mainViewModel.photoLiveData.observe(this, Observer {

        })
*/