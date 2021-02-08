package uk.me.mungorae.androidweekly.actions

import okhttp3.Headers
import okhttp3.HttpUrl
import okhttp3.mockwebserver.MockResponse
import uk.me.mungorae.androidweekly.scenarios.WebScenario

class WebActions {

    fun webViewReturnsHtml(dispatcher: WebScenario.TestDispatcher, url: String, html: String) {
        dispatcher.addMapping(url, MockResponse().apply {
            setResponseCode(200)
            setHeaders(Headers.headersOf("Content-Type", "text/html"))
            setBody(html)
        })
    }
}