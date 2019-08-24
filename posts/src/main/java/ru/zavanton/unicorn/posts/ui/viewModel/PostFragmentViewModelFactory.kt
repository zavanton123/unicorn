package ru.zavanton.unicorn.posts.ui.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import ru.zavanton.unicorn.core.Log
import ru.zavanton.unicorn.posts.di.component.PostFragmentScope
import javax.inject.Inject

@PostFragmentScope
class PostFragmentViewModelFactory @Inject constructor(
    private val viewModel: IPostFragmentViewModel
) : ViewModelProvider.Factory {

    init {
        Log.d()
    }

    override fun <T : ViewModel?> create(modelClass: Class<T>): T = viewModel as T
}