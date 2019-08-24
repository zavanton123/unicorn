package ru.zavanton.unicorn.posts.di.component

import dagger.Component
import dagger.Module
import ru.zavanton.unicorn.core.di.CoreApi
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

    // Subcomponents
    fun plusPostsActivityComponent(): PostsActivityComponent
}

@Module
class PostsModule






