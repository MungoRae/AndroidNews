package uk.me.mungorae.androidweekly.di

import dagger.Module
import dagger.Provides
import uk.me.mungorae.androidweekly.api.ArticlesApi
import uk.me.mungorae.androidweekly.api.FakeArticlesApi

@Module
class TestApiModule(private val articlesApi: FakeArticlesApi) {

    @Provides
    fun provideArticlesApi(): ArticlesApi {
        return articlesApi
    }
}