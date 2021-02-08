package uk.me.mungorae.androidweekly.stages

import uk.me.mungorae.androidweekly.actions.WebActions
import uk.me.mungorae.androidweekly.api.Article
import uk.me.mungorae.androidweekly.scenarios.WebScenario

class InternetReturnsHtmlForLink(
    private val dispatcher: WebScenario.TestDispatcher,
    private val article: Article,
    private val html: String,
) : Stage {

    override fun begin() {
        WebActions().webViewReturnsHtml(dispatcher, article.link, html)
    }
}