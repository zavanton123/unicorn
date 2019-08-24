package ru.zavanton.unicorn.posts.di

import ru.zavanton.unicorn.core.di.ComponentManager as CoreComponentManager

object ComponentManager {

    private var coreComponentManager = CoreComponentManager
    private var postsComponent: PostsComponent? = null

    fun getPostsComponent(): PostsComponent =
        postsComponent ?: DaggerPostsComponent
            .builder()
            .coreApi(coreComponentManager.getCoreComponent())
            .build()
            .also {
                postsComponent = it
            }

    fun clearPostsComponent() {
        postsComponent = null
    }
}