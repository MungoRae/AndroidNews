package uk.me.mungorae.androidnews.actions

import okhttp3.Headers
import okhttp3.mockwebserver.MockResponse
import uk.me.mungorae.androidnews.scenarios.WebScenario

class WebActions {

    fun webViewReturnsHtml(dispatcher: WebScenario.TestDispatcher, url: String, html: String) {
        dispatcher.addMapping(url, MockResponse().apply {
            setResponseCode(200)
            setHeaders(Headers.headersOf("Content-Type", "text/html"))
            setBody(html)
        })
    }
}