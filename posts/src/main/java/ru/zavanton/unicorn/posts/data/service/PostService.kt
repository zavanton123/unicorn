package ru.zavanton.unicorn.posts.data.service

import io.reactivex.Single
import retrofit2.http.GET
import ru.zavanton.unicorn.posts.data.model.AllPosts

interface PostService {

    @GET("r/all/hot.json?limit=1")
    fun fetchPosts(): Single<AllPosts>
}