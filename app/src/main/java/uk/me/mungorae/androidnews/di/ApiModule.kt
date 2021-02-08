package uk.me.mungorae.androidnews.di

import dagger.Module
import dagger.Provides
import uk.me.mungorae.androidnews.api.ArticlesApi

@Module
class ApiModule {

    @Provides
    fun provideArticlesApi(): ArticlesApi {
        return ArticlesApi.Retrofit()
    }
}