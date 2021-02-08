package uk.me.mungorae.androidnews.api

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.util.*

class FakeArticlesApi : ArticlesApi {
    val queue: Queue<Result<List<Article>>> = LinkedList()

    override suspend fun getArticles(): List<Article> {
        return withContext(Dispatchers.IO) {
            var result: Result<List<Article>>? = null
            do {
                result = queue.poll()
            } while (result == null)

            result.getOrThrow()
        }
    }
}