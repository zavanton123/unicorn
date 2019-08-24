package ru.zavanton.unicorn.posts.di

import ru.zavanton.unicorn.posts.di.component.DaggerPostComponent
import ru.zavanton.unicorn.posts.di.component.PostActivityComponent
import ru.zavanton.unicorn.posts.di.component.PostComponent
import ru.zavanton.unicorn.posts.di.component.PostFragmentComponent
import ru.zavanton.unicorn.core.di.ComponentManager as CoreComponentManager

object ComponentManager {

    private var coreComponentManager = CoreComponentManager

    private var postComponent: PostComponent? = null
    private var postActivityComponent: PostActivityComponent? = null
    private var postFragmentComponent: PostFragmentComponent? = null

    fun getPostComponent(): PostComponent =
        postComponent ?: DaggerPostComponent
            .builder()
            .coreApi(coreComponentManager.getCoreComponent())
            .build()
            .also {
                postComponent = it
            }

    fun clearPostComponent() {
        postActivityComponent = null
        postComponent = null
    }

    fun getPostActivityComponent(): PostActivityComponent =
        postActivityComponent ?: getPostComponent()
            .plusPostActivityComponent()
            .also {
                postActivityComponent = it
            }

    fun clearPostActivityComponent() {
        postActivityComponent = null
    }

    fun getPostFragmentComponent(): PostFragmentComponent {
        return postFragmentComponent ?: getPostActivityComponent()
            .plusPostFragmentComponent()
            .also {
                postFragmentComponent = it
            }
    }

    fun clearPostFragmentComponent() {
        postFragmentComponent = null
    }
}