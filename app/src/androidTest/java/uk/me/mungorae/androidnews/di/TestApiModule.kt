package uk.me.mungorae.androidnews.di

import dagger.Module
import dagger.Provides
import uk.me.mungorae.androidnews.api.ArticlesApi
import uk.me.mungorae.androidnews.api.FakeArticlesApi

@Module
class TestApiModule(private val articlesApi: FakeArticlesApi) {

    @Provides
    fun provideArticlesApi(): ArticlesApi {
        return articlesApi
    }
}