package uk.me.mungorae.androidweekly.di

import dagger.Module
import dagger.Provides
import uk.me.mungorae.androidweekly.api.ArticlesApi

@Module
class ApiModule {

    @Provides
    fun provideArticlesApi(): ArticlesApi {
        return ArticlesApi.Retrofit()
    }
}