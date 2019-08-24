package ru.zavanton.unicorn.posts.data.repository

import io.reactivex.Single
import ru.zavanton.unicorn.core.Log
import ru.zavanton.unicorn.posts.data.model.AllPosts
import ru.zavanton.unicorn.posts.data.service.PostService
import ru.zavanton.unicorn.posts.di.component.PostFragmentScope
import javax.inject.Inject

@PostFragmentScope
class PostRepository @Inject constructor(
    private val postService: PostService
) : IPostRepository {

    init {
        Log.d("postService: $postService")
    }

    override fun getPosts(): Single<AllPosts> {
        return postService.fetchPosts()
    }
}