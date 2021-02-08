package uk.me.mungorae.androidweekly.stages

import okhttp3.mockwebserver.MockWebServer
import uk.me.mungorae.androidweekly.actions.ArticleScreenActions
import uk.me.mungorae.androidweekly.api.Article

class ArticleScreenWillShowArticle(
    private val article: Article,
    private val mockWebServer: MockWebServer,
) : Stage {

    override fun begin() {
        ArticleScreenActions.hasTitle(article.title)
        ArticleScreenActions.loadedUrl(mockWebServer, article.link)
    }
}