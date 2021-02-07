package uk.me.mungorae.androidweekly.stages

import uk.me.mungorae.androidweekly.actions.ApiActions
import uk.me.mungorae.androidweekly.api.Article

class MainScreenArticleDisplayed(private val article: Article): Stage {
    override fun begin() {
        ApiActions.returnsArticles(listOf(article))
    }
}