package uk.me.mungorae.androidnews

import android.app.Application
import timber.log.Timber
import uk.me.mungorae.androidnews.di.AppComponent
import uk.me.mungorae.androidnews.di.DaggerAppComponent

open class App : Application() {
    private lateinit var component: AppComponent

    override fun onCreate() {
        super.onCreate()

        component = createAppComponent()
    }

    fun appComponent() = component

    protected open fun createAppComponent(): AppComponent {
        return DaggerAppComponent.builder()
            .build()
    }

    protected open fun setupLogging() {
        Timber.plant(Timber.DebugTree())
    }

    companion object {
        const val TAG: String = "AWApp"
    }
}