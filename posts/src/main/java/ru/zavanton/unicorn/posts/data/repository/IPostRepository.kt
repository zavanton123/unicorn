package ru.zavanton.unicorn.posts.data.repository

import io.reactivex.Single
import ru.zavanton.unicorn.posts.data.model.AllPosts

interface IPostRepository {

    fun getPosts(): Single<AllPosts>
}