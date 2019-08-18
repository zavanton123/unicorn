package ru.zavanton.unicorn.app

import android.app.Application
import ru.zavanton.unicorn.utils.Log

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        Log.d()
    }
}