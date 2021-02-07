package uk.me.mungorae.androidweekly.ui.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import uk.me.mungorae.androidweekly.api.Article

class ArticleAdapter(
    private val inflater: LayoutInflater,
    private val itemClickListener: (Article) -> Unit,
) : RecyclerView.Adapter<ArticleViewHolder>() {

    private val items = mutableListOf<Article>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleViewHolder {
        return ArticleViewHolder(inflater, parent, itemClickListener)
    }

    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {
        holder.onBind(items[position])
    }

    override fun getItemCount(): Int = items.size

    fun setItems(articles: List<Article>) {
        items.clear()
        items.addAll(articles)
        notifyDataSetChanged()
    }
}