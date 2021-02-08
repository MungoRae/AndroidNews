package uk.me.mungorae.androidweekly.scenarios

import android.net.Uri
import okhttp3.HttpUrl
import okhttp3.mockwebserver.Dispatcher
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import okhttp3.mockwebserver.RecordedRequest
import timber.log.Timber
import uk.me.mungorae.androidweekly.App.Companion.TAG

class WebScenario {
    private val mockServer: MockWebServer = MockWebServer().apply {
        dispatcher = TestDispatcher()
    }

    fun run(scenario: () -> Unit) {
        mockServer.start()
        scenario.invoke()
        mockServer.shutdown()
    }

    fun url(path: String): HttpUrl {
        return mockServer.url(path)
    }

    fun dispatcher(): TestDispatcher {
        return mockServer.dispatcher as TestDispatcher
    }

    fun webServer(): MockWebServer {
        return mockServer
    }

    class TestDispatcher : Dispatcher() {
        private val dispatches: MutableMap<String, MockResponse> = mutableMapOf()
        private val errorResponse = MockResponse()
            .setResponseCode(404)

        override fun dispatch(request: RecordedRequest): MockResponse {
            return dispatches[request.path] ?: errorResponse.setBody("No matching url ${request.requestUrl?.toUri()}")
        }

        fun addMapping(url: String, response: MockResponse) {
            val path = Uri.parse(url).path ?: throw IllegalArgumentException("$url invalid")
            dispatches[path] = response
        }
    }
}