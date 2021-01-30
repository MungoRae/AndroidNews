package uk.me.mungorae.androidweekly.di

import dagger.Component
import uk.me.mungorae.androidweekly.ui.main.MainFragment

@Component(
    modules = [
        AppModule::class,
        ViewModelModule::class,
        ApiModule::class,
    ]
)
interface AppComponent {

    fun inject(mainFragment: MainFragment)
}