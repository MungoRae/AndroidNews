package uk.me.mungorae.androidweekly.scenarios

import uk.me.mungorae.androidweekly.api.Article
import uk.me.mungorae.androidweekly.stages.MainScreenFinishedLoading
import uk.me.mungorae.androidweekly.stages.ArticlesToDownload
import uk.me.mungorae.androidweekly.stages.IWillSeeArticles

class NewsArticleListScenario: Scenario() {
    private val articles = createArticleList()

    override fun given() = listOf(ArticlesToDownload(articles))

    override fun when_() = listOf(MainScreenFinishedLoading())

    override fun then() = listOf(IWillSeeArticles(articles))

    private fun createArticleList(): List<Article> {
        return (0..100).map {
            Article(
                title = "Article $it",
                description = "Description $it",
            )
        }
    }
}