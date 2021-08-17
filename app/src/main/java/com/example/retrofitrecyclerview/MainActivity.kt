package com.example.retrofitrecyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.awaitResponse

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val newsRecyclerView: RecyclerView = findViewById(R.id.newsRecyclerView)
        newsRecyclerView.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)

        val call = ApiInterface.create().getNews()
        call.enqueue(object: Callback<News>{
            override fun onResponse(call: Call<News>, response: Response<News>) {
                Log.d("RESPONSE", response.body().toString())
                val adapter = response.body()?.articles?.let { CustomAdapter(it) }
                newsRecyclerView.adapter = adapter
            }

            override fun onFailure(call: Call<News>, t: Throwable) {
                Log.d("RESPONSE", "Error: "+t.message)
            }
        })

    }
}