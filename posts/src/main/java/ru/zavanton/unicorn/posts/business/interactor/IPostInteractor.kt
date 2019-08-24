package ru.zavanton.unicorn.posts.business.interactor

import io.reactivex.Single
import ru.zavanton.unicorn.posts.data.model.AllPosts

interface IPostInteractor {

    fun getPosts(): Single<AllPosts>
}