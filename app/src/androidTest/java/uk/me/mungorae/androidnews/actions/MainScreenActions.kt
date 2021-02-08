package uk.me.mungorae.androidnews.actions

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.doesNotExist
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions.actionOnItem
import androidx.test.espresso.contrib.RecyclerViewActions.scrollTo
import androidx.test.espresso.matcher.ViewMatchers.*
import uk.me.mungorae.androidnews.R
import uk.me.mungorae.androidnews.api.Article
import uk.me.mungorae.androidnews.ui.main.ArticleViewHolder

object MainScreenActions {

    fun hasNewsArticles(items: List<Article>) {
        onView(withText(R.string.error_article_download))
            .check(doesNotExist())

        items.forEach { article ->
            onView(withId(R.id.main_recycler_view))
                .perform(scrollTo<ArticleViewHolder>(hasDescendant(withText(article.title))))
            onView(withText(article.title))
                .check(matches(isDisplayed()))
            onView(withText(article.description))
                .check(matches(isDisplayed()))
        }
    }

    fun hasConnectionError() {
        onView(withText(R.string.error_article_download))
            .check(matches(isDisplayed()))
    }

    fun clickArticle(article: Article) {
        onView(withId(R.id.main_recycler_view))
            .perform(actionOnItem<ArticleViewHolder>(
                hasDescendant(withText(article.title)),
                click()
            ))
    }
}