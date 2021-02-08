package uk.me.mungorae.androidnews

import timber.log.Timber
import uk.me.mungorae.androidnews.api.FakeArticlesApi
import uk.me.mungorae.androidnews.di.AppComponent
import uk.me.mungorae.androidnews.di.DaggerTestComponent
import uk.me.mungorae.androidnews.di.TestApiModule

class TestApp : App() {
    val articlesApi = FakeArticlesApi()

    override fun createAppComponent(): AppComponent {
        return DaggerTestComponent.builder()
            .testApiModule(TestApiModule(articlesApi))
            .build()
    }

    override fun setupLogging() {
        super.setupLogging()
        Timber.plant(object: Timber.Tree() {
            override fun log(priority: Int, tag: String?, message: String, t: Throwable?) {
                println("$tag: $message")
                t?.printStackTrace()
            }

        })
    }
}