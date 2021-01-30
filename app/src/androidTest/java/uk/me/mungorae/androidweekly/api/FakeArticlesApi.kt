package uk.me.mungorae.androidweekly.api

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.util.*

class FakeArticlesApi: ArticlesApi {
    val queue: Queue<List<Article>> = LinkedList()

    override suspend fun getArticles(): List<Article> {
        return withContext(Dispatchers.IO) {
            var next: List<Article>? = null
            do {
                next = queue.poll()
            } while (next == null)

            next
        }
    }
}