package ru.zavanton.unicorn.posts.ui.activity.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import ru.zavanton.unicorn.core.Log
import ru.zavanton.unicorn.posts.di.component.PostActivityScope
import javax.inject.Inject

@PostActivityScope
class PostActivityViewModelProviderFactory @Inject constructor(
    private val viewModel: IPostActivityViewModel
) : ViewModelProvider.Factory {

    init {
        Log.d()
    }

    override fun <T : ViewModel?> create(modelClass: Class<T>): T = viewModel as T
}