package ru.zavanton.unicorn.posts.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import ru.zavanton.unicorn.core.Log
import ru.zavanton.unicorn.posts.R
import ru.zavanton.unicorn.posts.di.ComponentManager
import ru.zavanton.unicorn.posts.di.component.PostActivityViewModelProviderFactoryQualifier
import ru.zavanton.unicorn.posts.ui.activity.viewModel.IPostActivityViewModel
import ru.zavanton.unicorn.posts.ui.activity.viewModel.PostActivityViewModel
import ru.zavanton.unicorn.posts.ui.fragment.PostFragment
import javax.inject.Inject

class PostActivity : AppCompatActivity() {

    @Inject
    @field:PostActivityViewModelProviderFactoryQualifier
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private lateinit var viewModel: IPostActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        ComponentManager.getPostActivityComponent().inject(this)
        super.onCreate(savedInstanceState)

        Log.d()
        setContentView(R.layout.ac_posts)

        viewModel = ViewModelProviders.of(this, viewModelFactory)
            .get(PostActivityViewModel::class.java)

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
