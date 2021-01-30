package uk.me.mungorae.androidweekly.actions

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions.scrollTo
import androidx.test.espresso.matcher.ViewMatchers.*
import uk.me.mungorae.androidweekly.R
import uk.me.mungorae.androidweekly.api.Article
import uk.me.mungorae.androidweekly.ui.main.ArticleViewHolder

object MainScreenActions {

    fun hasNewsArticles(items: List<Article>) {
        items.forEachIndexed { index, article ->
            onView(withId(R.id.main_recycler_view))
                .perform(scrollTo<ArticleViewHolder>(hasDescendant(withText(article.title))))
            onView(withText(article.title))
                .check(matches(isDisplayed()))
            onView(withText(article.description))
                .check(matches(isDisplayed()))
        }
    }
}