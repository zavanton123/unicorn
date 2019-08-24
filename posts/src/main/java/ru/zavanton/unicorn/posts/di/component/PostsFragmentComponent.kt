package ru.zavanton.unicorn.posts.di.component

import dagger.Module
import dagger.Subcomponent
import ru.zavanton.unicorn.posts.ui.fragment.PostsFragment
import javax.inject.Scope

@Scope
@Retention
annotation class PostsFragmentScope

@PostsFragmentScope
@Subcomponent(
    modules = [
        PostsFragmentModule::class
    ]
)
interface PostsFragmentComponent {

    fun inject(fragment: PostsFragment)
}

@Module
class PostsFragmentModule
