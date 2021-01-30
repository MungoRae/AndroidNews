package uk.me.mungorae.androidweekly.di

import dagger.Component

@Component(
    modules = [
        AppModule::class,
        ViewModelModule::class,
        TestApiModule::class,
    ]
)
interface TestComponent: AppComponent {
}