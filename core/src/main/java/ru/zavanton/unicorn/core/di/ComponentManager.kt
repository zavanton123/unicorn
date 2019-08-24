package ru.zavanton.unicorn.core.di

import android.content.Context

object ComponentManager {

    private var appContext: Context? = null
    private var coreComponent: CoreComponent? = null

    fun init(appContext: Context) {
        this.appContext = appContext
    }

    fun getCoreComponent(): CoreComponent? =
        coreComponent ?: appContext?.let { appContext ->
            DaggerCoreComponent
                .builder()
                .coreModule(CoreModule(appContext))
                .build()
                .also {
                    coreComponent = it
                }
        }

    fun clearCoreComponent() {
        coreComponent = null
    }

}