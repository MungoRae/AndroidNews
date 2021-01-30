package uk.me.mungorae.androidweekly.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import uk.me.mungorae.androidweekly.App
import uk.me.mungorae.androidweekly.R
import javax.inject.Inject

class MainFragment : Fragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private val viewModel by viewModels<MainViewModel> { viewModelFactory }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        (requireActivity().application as App).appComponent().inject(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerView = view.findViewById<RecyclerView>(R.id.main_recycler_view)
        recyclerView.adapter = ArticleAdapter(layoutInflater)

        viewModel.articles.observe(viewLifecycleOwner) {
            recyclerView.articleAdapter().setItems(it)
        }

        viewModel.onViewCreated()
    }

    fun RecyclerView.articleAdapter(): ArticleAdapter {
        return adapter as ArticleAdapter
    }

    companion object {
        fun newInstance() = MainFragment()
    }
}