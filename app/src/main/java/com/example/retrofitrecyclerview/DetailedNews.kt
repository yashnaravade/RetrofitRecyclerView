package com.example.retrofitrecyclerview

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide

class DetailedNews : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detailed_news)

        val imgNewsHeader: ImageView = findViewById(R.id.imgNewsHeader)
        val tvaHeadline: TextView = findViewById(R.id.tvaHeadline)
        val tvaAuthor: TextView = findViewById(R.id.tvaAuthor)
        val tvaDescription: TextView = findViewById(R.id.tvaDescription)
        val btnReadMore: Button = findViewById(R.id.btnReadMore)


        val imageUrl: String = intent.getStringExtra("imageUrl").toString()
        Glide
            .with(this)
            .load(imageUrl)
            .centerCrop()
            .placeholder(R.drawable.ic_launcher_foreground)
            .into(imgNewsHeader)


        val headLine: String = intent.getStringExtra("headLine").toString()
        tvaHeadline.text = headLine

        val author: String = intent.getStringExtra("author").toString()
        tvaAuthor.text  = author

        val description: String = intent.getStringExtra("description").toString()
        tvaDescription.text = description

        val articleURL: String = intent.getStringExtra("articleURL").toString()

        btnReadMore.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse(articleURL)
            startActivity(intent)
        }

    }
}