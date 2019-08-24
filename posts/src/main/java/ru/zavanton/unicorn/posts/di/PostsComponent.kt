package ru.zavanton.unicorn.posts.di

import dagger.Component
import dagger.Module
import ru.zavanton.unicorn.core.di.CoreApi
import ru.zavanton.unicorn.posts.PostsActivity
import javax.inject.Scope

@Scope
@Retention
annotation class PostsScope

@PostsScope
@Component(
    modules = [
        PostsModule::class
    ],
    dependencies = [
        CoreApi::class
    ]
)
interface PostsComponent {

    fun inject(postsActivity: PostsActivity)
}

@Module
class PostsModule
