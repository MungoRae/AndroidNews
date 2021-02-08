package uk.me.mungorae.androidnews.di

import dagger.Component
import uk.me.mungorae.androidnews.ui.article.ArticleFragment
import uk.me.mungorae.androidnews.ui.main.MainFragment

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