package uk.me.mungorae.androidnews.stages

import uk.me.mungorae.androidnews.actions.WebActions
import uk.me.mungorae.androidnews.api.Article
import uk.me.mungorae.androidnews.scenarios.WebScenario

class InternetReturnsHtmlForLink(
    private val dispatcher: WebScenario.TestDispatcher,
    private val article: Article,
    private val html: String,
) : Stage {

    override fun begin() {
        WebActions().webViewReturnsHtml(dispatcher, article.link, html)
    }
}