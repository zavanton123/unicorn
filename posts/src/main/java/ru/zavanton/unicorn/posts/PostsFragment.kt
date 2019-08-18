package ru.zavanton.unicorn.posts

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

class PostsFragment : Fragment() {

    companion object {

        fun newInstance(): PostsFragment = PostsFragment()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fmt_posts, container, false)
    }
}