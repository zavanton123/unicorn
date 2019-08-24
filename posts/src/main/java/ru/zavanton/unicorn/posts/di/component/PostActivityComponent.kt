package ru.zavanton.unicorn.posts.di.component

import dagger.Module
import dagger.Subcomponent
import ru.zavanton.unicorn.posts.ui.activity.PostActivity
import javax.inject.Scope

@Scope
@Retention
annotation class PostActivityScope

@PostActivityScope
@Subcomponent(
    modules = [
        PostActivityModule::class
    ]
)
interface PostActivityComponent {

    // Subcomponents
    fun plusPostFragmentComponent(): PostFragmentComponent

    fun inject(postActivity: PostActivity)
}

@Module
class PostActivityModule
