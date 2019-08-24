package ru.zavanton.unicorn.posts.di

import dagger.Module
import dagger.Subcomponent
import ru.zavanton.unicorn.posts.ui.activity.PostsActivity
import javax.inject.Scope

@Scope
@Retention
annotation class PostsActivityScope

@PostsActivityScope
@Subcomponent(
    modules = [
        PostsActivityModule::class
    ]
)
interface PostsActivityComponent {

    fun inject(postsActivity: PostsActivity)
}

@Module
class PostsActivityModule
