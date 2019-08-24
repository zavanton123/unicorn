package ru.zavanton.unicorn.posts.data.repository

import ru.zavanton.unicorn.core.Log
import ru.zavanton.unicorn.posts.di.component.PostFragmentScope
import javax.inject.Inject

@PostFragmentScope
class PostRepository @Inject constructor() : IPostRepository {

    init {
        Log.d()
    }
}