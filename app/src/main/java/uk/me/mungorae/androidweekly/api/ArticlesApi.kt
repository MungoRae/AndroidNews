package uk.me.mungorae.androidweekly.api

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

interface ArticlesApi {

    suspend fun getArticles(): List<Article>

    class Retrofit : ArticlesApi {
        override suspend fun getArticles(): List<Article> {
            return withContext(Dispatchers.IO) {
                emptyList()
            }
        }
    }
}