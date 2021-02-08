package uk.me.mungorae.androidnews.stages

import uk.me.mungorae.androidnews.actions.ApiActions
import uk.me.mungorae.androidnews.api.Article

class ApiReturnsArticles(private val articles: List<Article>) : Stage {

    override fun begin() {
        ApiActions.returnsArticles(articles)
    }
}