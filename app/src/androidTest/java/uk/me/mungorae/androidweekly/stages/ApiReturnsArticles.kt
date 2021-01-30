package uk.me.mungorae.androidweekly.stages

import uk.me.mungorae.androidweekly.actions.ApiActions
import uk.me.mungorae.androidweekly.api.Article

class ApiReturnsArticles(private val articles: List<Article>) : Stage {

    override fun begin() {
        ApiActions.returnsArticles(articles)
    }
}