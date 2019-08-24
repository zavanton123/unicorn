package ru.zavanton.unicorn.di

import dagger.Component
import dagger.Module
import ru.zavanton.unicorn.ui.MainActivity
import ru.zavanton.unicorn.core.di.CoreApi
import javax.inject.Scope

@Scope
@Retention
annotation class AppScope

@AppScope
@Component(
    modules = [
        AppModule::class
    ],
    dependencies = [
        CoreApi::class
    ]
)
interface AppComponent {

    fun inject(mainActivity: MainActivity)
}

@Module
class AppModule