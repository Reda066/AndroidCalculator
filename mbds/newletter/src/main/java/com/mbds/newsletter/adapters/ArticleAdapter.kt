package com.mbds.newsletter.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.mbds.newsletter.R
import com.mbds.newsletter.model.Article

public class ArticleAdapter(public var dataset: MutableList<Article>) : RecyclerView.Adapter<ArticleAdapter.ViewHolder>() {


    class ViewHolder(val root: View) : RecyclerView.ViewHolder(root) {
        fun bind(item: Article) {
            val articleTitle = root.findViewById<TextView>(R.id.article_title)
            val imageView = root.findViewById<ImageView>(R.id.article_image)
            //val articleAuthor = root.findViewById<TextView>(R.id.article_author)

            articleTitle.text = item.title
            //articleAuthor.text = item.author


            Glide
                .with(root)
                .load(item.urlToImage)
                .fitCenter()
                .placeholder(R.drawable.placeholder)
                .into(imageView);
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val rootView =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.articles_list, parent, false)
        return ArticleAdapter.ViewHolder(rootView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(
            dataset[position]
        )
    }

    override fun getItemCount(): Int = dataset.size


}
