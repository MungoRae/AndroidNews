package uk.me.mungorae.androidweekly.actions

import androidx.test.platform.app.InstrumentationRegistry
import uk.me.mungorae.androidweekly.TestApp
import uk.me.mungorae.androidweekly.api.Article
import java.io.IOException

object ApiActions {
    fun returnsArticles(articles: List<Article>) {
        val app: TestApp = InstrumentationRegistry.getInstrumentation()
            .targetContext
            .applicationContext as TestApp
        app.articlesApi.queue.add(Result.success(articles))
    }

    fun returnsError() {
        val app: TestApp = InstrumentationRegistry.getInstrumentation()
            .targetContext
            .applicationContext as TestApp
        app.articlesApi.queue.add(Result.failure(IOException("500 Nope!")))
    }
}