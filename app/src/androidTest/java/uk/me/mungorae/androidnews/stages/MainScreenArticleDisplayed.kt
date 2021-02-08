package uk.me.mungorae.androidnews.stages

import uk.me.mungorae.androidnews.actions.ApiActions
import uk.me.mungorae.androidnews.api.Article

class MainScreenArticleDisplayed(private val article: Article): Stage {
    override fun begin() {
        ApiActions.returnsArticles(listOf(article))
    }
}