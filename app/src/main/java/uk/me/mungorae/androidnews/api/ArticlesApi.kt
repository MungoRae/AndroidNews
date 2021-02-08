package uk.me.mungorae.androidnews.api

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

interface ArticlesApi {

    suspend fun getArticles(): List<Article>

    class Retrofit : ArticlesApi {
        override suspend fun getArticles(): List<Article> {
            return withContext(Dispatchers.IO) {
                listOf(Article(
                    title = "Dagger on Android",
                    description = "Material is a design system created by Google to help teams build high-quality digital experiences for Android, iOS, Flutter, and the web.",
                    link = "https://www.bbc.co.uk",
                ))
            }
        }
    }
}