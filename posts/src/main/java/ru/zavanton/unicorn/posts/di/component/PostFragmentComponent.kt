package ru.zavanton.unicorn.posts.di.component

import dagger.Module
import dagger.Subcomponent
import ru.zavanton.unicorn.posts.ui.fragment.PostFragment
import javax.inject.Scope

@Scope
@Retention
annotation class PostFragmentScope

@PostFragmentScope
@Subcomponent(
    modules = [
        PostFragmentModule::class
    ]
)
interface PostFragmentComponent {

    fun inject(fragment: PostFragment)
}

@Module
class PostFragmentModule
