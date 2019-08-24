package ru.zavanton.unicorn.posts.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import ru.zavanton.unicorn.core.Log
import ru.zavanton.unicorn.posts.R
import ru.zavanton.unicorn.posts.di.ComponentManager
import ru.zavanton.unicorn.posts.ui.viewModel.IPostFragmentViewModel
import ru.zavanton.unicorn.posts.ui.viewModel.PostFragmentViewModel
import javax.inject.Inject

class PostFragment : Fragment() {

    companion object {

        fun newInstance(): PostFragment = PostFragment()
    }

    @Inject
    lateinit var viewModelProviderFactory: ViewModelProvider.Factory

    private lateinit var viewModel: IPostFragmentViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        ComponentManager.getPostFragmentComponent().inject(this)
        super.onCreate(savedInstanceState)

        viewModel = ViewModelProviders.of(this, viewModelProviderFactory)
            .get(PostFragmentViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fmt_posts, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d("viewModel: $viewModel")
    }
}