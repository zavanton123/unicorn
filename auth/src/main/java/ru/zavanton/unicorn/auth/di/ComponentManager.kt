package ru.zavanton.unicorn.auth.di

import ru.zavanton.unicorn.core.di.ComponentManager as CoreComponentManager

object ComponentManager {

    private var coreComponentManager = CoreComponentManager
    private var authComponent: AuthComponent? = null

    fun getAuthComponent(): AuthComponent =
        authComponent ?: DaggerAuthComponent
            .builder()
            .coreApi(coreComponentManager.getCoreComponent())
            .build()
            .also {
                authComponent = it
            }

    fun clearAuthComponent() {
        authComponent = null
    }
}