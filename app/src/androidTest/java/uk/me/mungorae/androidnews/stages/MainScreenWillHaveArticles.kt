package uk.me.mungorae.androidnews.stages

import uk.me.mungorae.androidnews.api.Article
import uk.me.mungorae.androidnews.actions.MainScreenActions

class MainScreenWillHaveArticles(private val articles: List<Article>): Stage {
    override fun begin() {
        MainScreenActions.hasNewsArticles(articles)
    }
}