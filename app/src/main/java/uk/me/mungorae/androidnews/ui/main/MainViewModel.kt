package uk.me.mungorae.androidnews.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import timber.log.Timber
import uk.me.mungorae.androidnews.App
import uk.me.mungorae.androidnews.api.Article
import uk.me.mungorae.androidnews.api.ArticlesApi
import uk.me.mungorae.androidnews.ui.SingleLiveEvent
import javax.inject.Inject

class MainViewModel @Inject constructor(
    private val articlesApi: ArticlesApi,
) : ViewModel() {

    private val _articles = MutableLiveData<List<Article>>()
    val articles: LiveData<List<Article>> = _articles

    private val _error = MutableLiveData<Error>()
    val error: LiveData<Error> = _error

    val showArticle = SingleLiveEvent<Article>()

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

    fun onArticleSelected(article: Article) {
        showArticle.postValue(article)
    }

    sealed class Error {
        object Download: Error()
        object None: Error()
    }
}