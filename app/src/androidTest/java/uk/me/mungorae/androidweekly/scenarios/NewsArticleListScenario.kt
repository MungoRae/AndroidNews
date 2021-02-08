package uk.me.mungorae.androidweekly.scenarios

import uk.me.mungorae.androidweekly.api.Article
import uk.me.mungorae.androidweekly.stages.MainScreenFinishedLoading
import uk.me.mungorae.androidweekly.stages.ApiReturnsArticles
import uk.me.mungorae.androidweekly.stages.MainScreenWillHaveArticles

class NewsArticleListScenario: Scenario() {
    private val articles = createArticleList()

    override fun given() = listOf(ApiReturnsArticles(articles))

    override fun when_() = listOf(MainScreenFinishedLoading())

    override fun then() = listOf(MainScreenWillHaveArticles(articles))

    private fun createArticleList(): List<Article> {
        return (0..100).map {
            Article(
                title = "Article $it",
                description = "Description $it",
                link = "https://mysite.com",
            )
        }
    }
}