package uk.me.mungorae.androidweekly.ui.article

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebResourceRequest
import android.webkit.WebResourceResponse
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.google.android.material.appbar.MaterialToolbar
import okhttp3.Headers
import okhttp3.OkHttpClient
import okhttp3.Request
import timber.log.Timber
import uk.me.mungorae.androidweekly.App
import uk.me.mungorae.androidweekly.App.Companion.TAG
import uk.me.mungorae.androidweekly.R
import uk.me.mungorae.androidweekly.api.Article
import javax.inject.Inject

class ArticleFragment : Fragment() {

    @Inject
    lateinit var webViewClient: OkHttpClient

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        (requireActivity().application as App).appComponent().inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.article_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val article: Article = requireArguments().get("article") as Article?
            ?: throw IllegalStateException("Must pass article")

        view.findViewById<MaterialToolbar>(R.id.article_toolbar).title = article.title
        view.findViewById<TextView>(R.id.article_text_description).text = article.description
        val webView = view.findViewById<WebView>(R.id.article_webview)
        webView.settings.javaScriptEnabled = true
        webView.webViewClient = ArticleWebViewClient(webViewClient)

        webView.loadUrl(article.link)
    }

    class ArticleWebViewClient(private val client: OkHttpClient) : WebViewClient() {
        override fun shouldInterceptRequest(
            view: WebView,
            url: String
        ): WebResourceResponse? {
            return response(url)
        }

        override fun shouldInterceptRequest(
            view: WebView,
            request: WebResourceRequest
        ): WebResourceResponse? {
            return response(request.url.toString(), request.method, request.requestHeaders)
        }

        private fun response(
            url: String,
            method: String = "GET",
            headers: Map<String, String> = emptyMap()
        ): WebResourceResponse? {
            val keyValueHeaderArray: Array<String> = headers
                .map {
                    listOf(it.key, it.value)
                }
                .flatten()
                .toTypedArray()

            val request = Request.Builder()
                .method(method, null)
                .url(url)
                .headers(Headers.headersOf(*keyValueHeaderArray))
                .build()

            runCatching {
                client.newCall(request).execute()
            }.onSuccess {
                return WebResourceResponse(
                    "",
                    "",
                    it.code,
                    it.message,
                    it.headers.toMap(),
                    it.body?.byteStream(),
                )
            }.onFailure {
                Timber.tag(TAG).e(it)
            }

            return null
        }
    }
}