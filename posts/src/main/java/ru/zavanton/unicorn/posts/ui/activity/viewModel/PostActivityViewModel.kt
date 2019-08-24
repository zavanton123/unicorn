package ru.zavanton.unicorn.posts.ui.activity.viewModel

import androidx.lifecycle.ViewModel
import ru.zavanton.unicorn.core.Log
import ru.zavanton.unicorn.posts.di.ComponentManager
import ru.zavanton.unicorn.posts.di.component.PostActivityScope
import javax.inject.Inject

@PostActivityScope
class PostActivityViewModel @Inject constructor() : ViewModel(), IPostActivityViewModel {

    init {
        Log.d()
    }

    override fun onCleared() {
        super.onCleared()
        Log.d()

        ComponentManager.clearPostActivityComponent()
    }
}