package uk.me.mungorae.androidweekly.stages

import uk.me.mungorae.androidweekly.api.Article
import uk.me.mungorae.androidweekly.actions.MainScreenActions

class MainScreenWillHaveArticles(private val articles: List<Article>): Stage {
    override fun begin() {
        MainScreenActions.hasNewsArticles(articles)
    }
}