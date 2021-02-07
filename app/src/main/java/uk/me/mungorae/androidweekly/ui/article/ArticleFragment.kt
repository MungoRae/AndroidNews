package uk.me.mungorae.androidweekly.ui.article

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.google.android.material.appbar.MaterialToolbar
import uk.me.mungorae.androidweekly.R
import uk.me.mungorae.androidweekly.api.Article

class ArticleFragment : Fragment() {

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
    }
}