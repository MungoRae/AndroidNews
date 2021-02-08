package uk.me.mungorae.androidnews.ui.main

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import uk.me.mungorae.androidnews.R
import uk.me.mungorae.androidnews.api.Article

class ArticleViewHolder(
    inflater:LayoutInflater,
    parent: ViewGroup,
    private val itemClickListener: (Article) -> Unit
): RecyclerView.ViewHolder(
    inflater.inflate(R.layout.view_article, parent, false)
) {
    fun onBind(article: Article) {
        itemView.findViewById<TextView>(R.id.article_item_title).text = article.title
        itemView.findViewById<TextView>(R.id.article_item_description).text = article.description
        itemView.setOnClickListener {
            itemClickListener.invoke(article)
        }
    }
}