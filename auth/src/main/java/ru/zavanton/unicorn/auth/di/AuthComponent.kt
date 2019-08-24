package ru.zavanton.unicorn.auth.di

import dagger.Component
import dagger.Module
import ru.zavanton.unicorn.auth.ui.TokenActivity
import ru.zavanton.unicorn.core.di.CoreApi
import javax.inject.Scope

@Scope
@Retention
annotation class AuthScope

interface AuthApi

@AuthScope
@Component(
    modules = [
        AuthModule::class
    ],
    dependencies = [
        CoreApi::class
    ]
)
interface AuthComponent : AuthApi {

    fun inject(tokenActivity: TokenActivity)
}

@Module
class AuthModule
