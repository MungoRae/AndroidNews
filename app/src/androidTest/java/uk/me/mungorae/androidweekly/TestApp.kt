package uk.me.mungorae.androidweekly

import uk.me.mungorae.androidweekly.api.FakeArticlesApi
import uk.me.mungorae.androidweekly.di.AppComponent
import uk.me.mungorae.androidweekly.di.DaggerTestComponent
import uk.me.mungorae.androidweekly.di.TestApiModule

class TestApp : App() {
    val articlesApi = FakeArticlesApi()

    override fun createAppComponent(): AppComponent {
        return DaggerTestComponent.builder()
            .testApiModule(TestApiModule(articlesApi))
            .build()
    }
}