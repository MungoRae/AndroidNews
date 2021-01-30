package uk.me.mungorae.androidweekly

import android.app.Application
import uk.me.mungorae.androidweekly.di.AppComponent
import uk.me.mungorae.androidweekly.di.DaggerAppComponent

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
}