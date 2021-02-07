package uk.me.mungorae.androidweekly.stages

import uk.me.mungorae.androidweekly.actions.MainScreenActions
import uk.me.mungorae.androidweekly.api.Article

class MainScreenUserClicksArticle(private val article: Article) : Stage {
    override fun begin() {
        MainScreenActions.clickArticle(article)
    }
}