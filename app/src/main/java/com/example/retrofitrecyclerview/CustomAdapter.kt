package com.example.retrofitrecyclerview

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class CustomAdapter(val newArticleList: List<Article>): RecyclerView.Adapter<CustomAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.news_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
       val article: Article = newArticleList.get(position)
       holder.tvHeadline.text = article.title
       holder.tvAuthor.text = article.author

        Glide
            .with(holder.ivArticle.context)
            .load(article.urlToImage)
            .centerCrop()
            .placeholder(R.drawable.ic_launcher_foreground)
            .into(holder.ivArticle);

        holder.cardNewsItem.setOnClickListener {
            val intent =  Intent(holder.cardNewsItem.context, DetailedNews::class.java)

            holder.cardNewsItem.context.startActivity(intent)
        }


    }

    override fun getItemCount(): Int {
        return newArticleList.size
    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val ivArticle: ImageView = itemView.findViewById(R.id.ivArticle)
        val tvHeadline: TextView = itemView.findViewById(R.id.tvHeadline)
        val tvAuthor: TextView = itemView.findViewById(R.id.tvAuthor)
        val cardNewsItem: CardView = itemView.findViewById(R.id.cardNewsItem)
    }
}