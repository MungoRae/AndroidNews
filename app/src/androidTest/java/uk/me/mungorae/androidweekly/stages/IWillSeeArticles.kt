package uk.me.mungorae.androidweekly.stages

import uk.me.mungorae.androidweekly.api.Article
import uk.me.mungorae.androidweekly.actions.MainScreenActions

class IWillSeeArticles(private val articles: List<Article>): Stage {
    override fun begin() {
        MainScreenActions.hasNewsArticles(articles)
    }
}