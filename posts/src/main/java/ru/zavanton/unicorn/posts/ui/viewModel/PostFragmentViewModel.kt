package ru.zavanton.unicorn.posts.ui.viewModel

import androidx.lifecycle.ViewModel
import ru.zavanton.unicorn.core.Log
import ru.zavanton.unicorn.posts.business.interactor.IPostInteractor
import ru.zavanton.unicorn.posts.di.ComponentManager
import ru.zavanton.unicorn.posts.di.component.PostFragmentScope
import javax.inject.Inject

@PostFragmentScope
class PostFragmentViewModel @Inject constructor(
    private val postInteractor: IPostInteractor
) : ViewModel(), IPostFragmentViewModel {

    init {
        Log.d("postInteractor: $postInteractor")
    }

    override fun onCleared() {
        super.onCleared()
        Log.d()

        ComponentManager.clearPostFragmentComponent()
    }

}