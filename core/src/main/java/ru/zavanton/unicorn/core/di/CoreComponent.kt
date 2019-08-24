package ru.zavanton.unicorn.core.di

import android.content.Context
import dagger.Component
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.CallAdapter
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Scope

@Scope
@Retention
annotation class CoreScope

interface CoreApi {

    fun provideAppContext(): Context

    fun provideRetrofit(): Retrofit

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

    companion object {

        private const val BASE_URL = "https://reddit.com/"
    }

    @CoreScope
    @Provides
    fun provideRetrofit(
        okHttpClient: OkHttpClient,
        converterFactory: Converter.Factory,
        adapterFactory: CallAdapter.Factory
    ): Retrofit =
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(converterFactory)
            .addCallAdapterFactory(adapterFactory)
            .build()

    @CoreScope
    @Provides
    fun provideOkHttpClient(): OkHttpClient = OkHttpClient()

    @CoreScope
    @Provides
    fun provideConverterFactory(): Converter.Factory = GsonConverterFactory.create()

    @CoreScope
    @Provides
    fun provideAdapterFactory(): CallAdapter.Factory = RxJava2CallAdapterFactory.create()
}

