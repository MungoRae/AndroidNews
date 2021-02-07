package uk.me.mungorae.androidweekly.scenarios

import uk.me.mungorae.androidweekly.api.Article
import uk.me.mungorae.androidweekly.stages.ArticleScreenWillShowArticle
import uk.me.mungorae.androidweekly.stages.MainScreenArticleDisplayed
import uk.me.mungorae.androidweekly.stages.MainScreenUserClicksArticle
import uk.me.mungorae.androidweekly.stages.Stage

class ViewArticleScenario: Scenario() {
    private val article = Article("My Article", "My Description")

    override fun given(): List<Stage> {
        return listOf(MainScreenArticleDisplayed(article))
    }

    override fun when_(): List<Stage> {
        return listOf(
            MainScreenUserClicksArticle(article)
        )
    }

    override fun then(): List<Stage> {
        return listOf(
            ArticleScreenWillShowArticle(article)
        )
    }
}