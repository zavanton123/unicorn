package ru.zavanton.unicorn.di

import android.content.Context
import ru.zavanton.unicorn.core.di.ComponentManager as CoreComponentManager

object ComponentManager {

    private var coreComponentManager = CoreComponentManager

    private var appComponent: AppComponent? = null

    fun init(appContext: Context) {
        coreComponentManager.init(appContext)
    }

    fun getAppComponent(): AppComponent =
        appComponent ?: DaggerAppComponent
            .builder()
            .coreApi(coreComponentManager.getCoreComponent())
            .build()
            .also {
                appComponent = it
            }

    fun clearAppComponent() {
        appComponent = null
    }

}