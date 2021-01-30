package uk.me.mungorae.androidweekly.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import timber.log.Timber
import uk.me.mungorae.androidweekly.App
import uk.me.mungorae.androidweekly.api.Article
import uk.me.mungorae.androidweekly.api.ArticlesApi
import uk.me.mungorae.androidweekly.coroutines.DispatcherProvider
import java.lang.Error
import javax.inject.Inject

class MainViewModel @Inject constructor(
    private val articlesApi: ArticlesApi,
) : ViewModel() {

    private val _articles = MutableLiveData<List<Article>>()
    val articles: LiveData<List<Article>> = _articles

    private val _error = MutableLiveData<Error>()
    val error: LiveData<Error> = _error

    fun onViewCreated() {
        _error.postValue(Error.None)

        viewModelScope.launch {
            // clear any previous errors
            _error.postValue(Error.None)

            kotlin.runCatching {
                articlesApi.getArticles()
            }.onSuccess {
                _articles.postValue(it)
            }.onFailure {
                Timber.tag(App.TAG).e(it)
                _error.postValue(Error.Download)
            }
        }
    }

    sealed class Error {
        object Download: Error()
        object None: Error()
    }
}