package ru.zavanton.unicorn.core.di

import android.content.Context
import dagger.Component
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import javax.inject.Scope

@Scope
@Retention
annotation class CoreScope

interface CoreApi {

    fun provideAppContext(): Context
    fun provideOkHttpClient(): OkHttpClient
}

@CoreScope
@Component(
    modules = [
        CoreModule::class,
        NetworkModule::class
    ]
)
interface CoreComponent : CoreApi {
}

@Module
class CoreModule(private val appContext: Context) {

    @CoreScope
    @Provides
    fun provideAppContext(): Context = appContext
}

@Module
class NetworkModule {

    @CoreScope
    @Provides
    fun provideOkHttpClient(): OkHttpClient = OkHttpClient()
}

