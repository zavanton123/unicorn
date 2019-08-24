package ru.zavanton.unicorn.posts.ui.fragment.viewModel

import androidx.lifecycle.ViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import ru.zavanton.unicorn.core.Log
import ru.zavanton.unicorn.posts.business.interactor.IPostInteractor
import ru.zavanton.unicorn.posts.di.ComponentManager
import ru.zavanton.unicorn.posts.di.component.PostFragmentScope
import javax.inject.Inject

@PostFragmentScope
class PostFragmentViewModel @Inject constructor(
    private val postInteractor: IPostInteractor
) : ViewModel(), IPostFragmentViewModel {

    private val compositeDisposable = CompositeDisposable()

    init {
        Log.d("postInteractor: $postInteractor")

        getPosts()
    }

    private fun getPosts() {
        compositeDisposable.add(
            postInteractor.getPosts()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                    {
                        Log.d("All posts: $it")
                    }, {
                        Log.e(it, "Failed to get posts")
                    }
                )
        )
    }

    override fun onCleared() {
        super.onCleared()
        Log.d()

        if (compositeDisposable.isDisposed) {
            compositeDisposable.dispose()
        }

        ComponentManager.clearPostFragmentComponent()
    }
}