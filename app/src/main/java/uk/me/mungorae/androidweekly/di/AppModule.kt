package uk.me.mungorae.androidweekly.di

import android.content.Context
import dagger.Module
import dagger.Provides

@Module
class AppModule(private val context: Context) {

    @Provides
    fun provideContext(): Context {
        return context
    }
}