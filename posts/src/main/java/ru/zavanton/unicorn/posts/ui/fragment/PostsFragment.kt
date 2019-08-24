package ru.zavanton.unicorn.posts.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import okhttp3.OkHttpClient
import ru.zavanton.unicorn.core.Log
import ru.zavanton.unicorn.posts.R
import ru.zavanton.unicorn.posts.di.ComponentManager
import javax.inject.Inject

class PostsFragment : Fragment() {

    @Inject
    lateinit var okHttpClient: OkHttpClient

    companion object {

        fun newInstance(): PostsFragment =
            PostsFragment()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        ComponentManager.getPostsFragmentComponent().inject(this)
        super.onCreate(savedInstanceState)

        Log.d("okHttpClient: $okHttpClient")
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fmt_posts, container, false)
    }
}