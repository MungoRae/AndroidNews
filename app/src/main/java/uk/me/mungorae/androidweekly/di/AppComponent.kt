package uk.me.mungorae.androidweekly.di

import dagger.Component
import uk.me.mungorae.androidweekly.ui.article.ArticleFragment
import uk.me.mungorae.androidweekly.ui.main.MainFragment
import javax.inject.Singleton

@Component(
    modules = [
        AppModule::class,
        ViewModelModule::class,
        ApiModule::class,
        NetworkingModule::class,
    ]
)
@ApplicationScope
interface AppComponent {

    fun inject(mainFragment: MainFragment)
    fun inject(articleFragment: ArticleFragment)
}