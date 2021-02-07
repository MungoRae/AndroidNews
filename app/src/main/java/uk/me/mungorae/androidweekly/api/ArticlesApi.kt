package uk.me.mungorae.androidweekly.api

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

interface ArticlesApi {

    suspend fun getArticles(): List<Article>

    class Retrofit : ArticlesApi {
        override suspend fun getArticles(): List<Article> {
            return withContext(Dispatchers.IO) {
                listOf(Article("Dagger on Android", "Material is a design system created by Google to help teams build high-quality digital experiences for Android, iOS, Flutter, and the web."))
            }
        }
    }
}