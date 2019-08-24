package ru.zavanton.unicorn.app

import android.app.Application
import ru.zavanton.unicorn.di.ComponentManager
import ru.zavanton.unicorn.core.Log

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        Log.d()

        ComponentManager.init(this)
    }
}