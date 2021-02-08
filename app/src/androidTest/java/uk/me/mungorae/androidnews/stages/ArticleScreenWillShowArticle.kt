package uk.me.mungorae.androidnews.stages

import okhttp3.mockwebserver.MockWebServer
import uk.me.mungorae.androidnews.actions.ArticleScreenActions
import uk.me.mungorae.androidnews.api.Article

class ArticleScreenWillShowArticle(
    private val article: Article,
    private val mockWebServer: MockWebServer,
) : Stage {

    override fun begin() {
        ArticleScreenActions.hasTitle(article.title)
        ArticleScreenActions.loadedUrl(mockWebServer, article.link)
    }
}