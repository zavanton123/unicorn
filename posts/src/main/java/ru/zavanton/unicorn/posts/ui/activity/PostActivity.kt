package ru.zavanton.unicorn.posts.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ru.zavanton.unicorn.core.Log
import ru.zavanton.unicorn.posts.R
import ru.zavanton.unicorn.posts.di.ComponentManager
import ru.zavanton.unicorn.posts.ui.fragment.PostFragment

class PostActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        ComponentManager.getPostActivityComponent().inject(this)

        super.onCreate(savedInstanceState)
        Log.d()
        setContentView(R.layout.ac_posts)

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
