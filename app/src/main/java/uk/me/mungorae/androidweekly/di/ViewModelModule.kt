package uk.me.mungorae.androidweekly.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import uk.me.mungorae.androidweekly.ui.main.MainViewModel

@Module
abstract class ViewModelModule {

    @Binds
    abstract fun bindViewModelFactory(
        factory: ViewModelFactory
    ): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    internal abstract fun postListViewModel(viewModel: MainViewModel): ViewModel
}