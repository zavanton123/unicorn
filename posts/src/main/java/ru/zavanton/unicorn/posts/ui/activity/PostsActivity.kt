package ru.zavanton.unicorn.posts.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import okhttp3.OkHttpClient
import ru.zavanton.unicorn.core.Log
import ru.zavanton.unicorn.posts.R
import ru.zavanton.unicorn.posts.di.ComponentManager
import ru.zavanton.unicorn.posts.ui.fragment.PostsFragment
import javax.inject.Inject

class PostsActivity : AppCompatActivity() {

    @Inject
    lateinit var okHttpClient: OkHttpClient

    override fun onCreate(savedInstanceState: Bundle?) {
        ComponentManager.getPostsActivityComponent().inject(this)

        super.onCreate(savedInstanceState)
        Log.d()
        setContentView(R.layout.ac_posts)

        Log.d("okHttpClient: $okHttpClient")

        addPostsFragment()
    }

    private fun addPostsFragment() {
        if (supportFragmentManager.findFragmentById(R.id.fmtContainer) == null) {
            supportFragmentManager.beginTransaction()
                .add(
                    R.id.fmtContainer,
                    PostsFragment.newInstance()
                )
                .commit()
        }
    }
}
