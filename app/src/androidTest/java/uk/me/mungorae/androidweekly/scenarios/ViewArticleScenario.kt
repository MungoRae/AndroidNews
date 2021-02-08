package uk.me.mungorae.androidweekly.scenarios

import uk.me.mungorae.androidweekly.api.Article
import uk.me.mungorae.androidweekly.stages.*

class ViewArticleScenario: Scenario() {
    private val html = """
        <html>
        <head>
        <title>My Teams Meeting</title>
        </head>
        <body>
            My Body is here and its the best
        </body>
        </html>
    """.trimIndent()
    private val webScenario: WebScenario = WebScenario()
    private val article by lazy {
        Article("My Article", "My Description", webScenario.url("/").toUrl().toString())
    }

    override fun runScenario(scenario: () -> Unit) {
        webScenario.run(scenario)
    }

    override fun given(): List<Stage> {
        return listOf(
            InternetReturnsHtmlForLink(webScenario.dispatcher(), article, html),
            MainScreenArticleDisplayed(article),
        )
    }

    override fun when_(): List<Stage> {
        return listOf(
            MainScreenUserClicksArticle(article)
        )
    }

    override fun then(): List<Stage> {
        return listOf(
            ArticleScreenWillShowArticle(article, webScenario.webServer())
        )
    }

}