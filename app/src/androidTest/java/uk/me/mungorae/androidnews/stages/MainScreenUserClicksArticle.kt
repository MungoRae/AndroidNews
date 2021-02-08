package uk.me.mungorae.androidnews.stages

import uk.me.mungorae.androidnews.actions.MainScreenActions
import uk.me.mungorae.androidnews.api.Article

class MainScreenUserClicksArticle(private val article: Article) : Stage {
    override fun begin() {
        MainScreenActions.clickArticle(article)
    }
}