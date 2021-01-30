package uk.me.mungorae.androidweekly.stages

import androidx.test.platform.app.InstrumentationRegistry
import uk.me.mungorae.androidweekly.TestApp
import uk.me.mungorae.androidweekly.api.Article

class ArticlesToDownload(private val articles: List<Article>) : Stage {

    override fun begin() {
        val app: TestApp = InstrumentationRegistry.getInstrumentation()
            .targetContext
            .applicationContext as TestApp
        app.articlesApi.queue.add(articles)
    }
}