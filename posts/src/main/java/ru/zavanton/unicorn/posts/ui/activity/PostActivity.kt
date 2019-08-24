package ru.zavanton.unicorn.posts.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import okhttp3.OkHttpClient
import ru.zavanton.unicorn.core.Log
import ru.zavanton.unicorn.posts.R
import ru.zavanton.unicorn.posts.di.ComponentManager
import ru.zavanton.unicorn.posts.ui.fragment.PostFragment
import javax.inject.Inject

class PostActivity : AppCompatActivity() {

    @Inject
    lateinit var okHttpClient: OkHttpClient

    override fun onCreate(savedInstanceState: Bundle?) {
        ComponentManager.getPostActivityComponent().inject(this)

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
                    PostFragment.newInstance()
                )
                .commit()
        }
    }
}
