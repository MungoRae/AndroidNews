package uk.me.mungorae.androidweekly.actions

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import uk.me.mungorae.androidweekly.R

object ArticleScreenActions {

    fun hasTitle(title: String) {
        onView(withText(title))
            .check(matches(isDisplayed()))
    }

    fun hasDescription(description: String) {
        onView(withText(description))
            .check(matches(isDisplayed()))
    }
}