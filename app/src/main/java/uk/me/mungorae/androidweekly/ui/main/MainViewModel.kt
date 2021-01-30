package uk.me.mungorae.androidweekly.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
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

    fun onViewCreated() {
        viewModelScope.launch {
            kotlin.runCatching {
                articlesApi.getArticles()
            }.onSuccess {
                _articles.postValue(it)
            }.onFailure {

            }
        }
    }

    sealed class Error {
        object Download: Error()
    }
}