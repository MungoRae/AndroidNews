package uk.me.mungorae.androidnews.actions

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import okhttp3.mockwebserver.MockWebServer
import okhttp3.mockwebserver.RecordedRequest
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.CoreMatchers.equalTo

object ArticleScreenActions {

    fun hasTitle(title: String) {
        onView(withText(title))
            .check(matches(isDisplayed()))
    }

    fun loadedUrl(mockWebServer: MockWebServer, url: String) {
        val request: RecordedRequest = mockWebServer.takeRequest()
        assertThat(request.requestUrl?.toString(), `is`(equalTo(url)))
    }
}