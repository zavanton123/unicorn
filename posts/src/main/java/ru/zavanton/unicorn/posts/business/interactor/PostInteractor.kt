package ru.zavanton.unicorn.posts.business.interactor

import io.reactivex.Single
import ru.zavanton.unicorn.core.Log
import ru.zavanton.unicorn.posts.data.model.AllPosts
import ru.zavanton.unicorn.posts.data.repository.IPostRepository
import ru.zavanton.unicorn.posts.di.component.PostFragmentScope
import javax.inject.Inject

@PostFragmentScope
class PostInteractor @Inject constructor(
    private val postRepository: IPostRepository
) : IPostInteractor {

    init {
        Log.d("postRepository: $postRepository")
    }

    override fun getPosts(): Single<AllPosts> = postRepository.getPosts()
}