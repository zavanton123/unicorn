package ru.zavanton.unicorn.posts

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ru.zavanton.unicorn.utils.Log

class PostsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d()
        setContentView(R.layout.ac_posts)

        addPostsFragment()
    }

    private fun addPostsFragment() {
        if (supportFragmentManager.findFragmentById(R.id.fmtContainer) == null) {
            supportFragmentManager.beginTransaction()
                .add(R.id.fmtContainer, PostsFragment.newInstance())
                .commit()
        }
    }
}
