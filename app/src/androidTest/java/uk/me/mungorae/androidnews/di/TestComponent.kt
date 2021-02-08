package uk.me.mungorae.androidnews.di

import dagger.Component

@Component(
    modules = [
        AppModule::class,
        ViewModelModule::class,
        TestApiModule::class,
        NetworkingModule::class,
    ]
)
@ApplicationScope
interface TestComponent: AppComponent {
}