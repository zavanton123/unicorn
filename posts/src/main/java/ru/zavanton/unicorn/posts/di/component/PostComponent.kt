package ru.zavanton.unicorn.posts.di.component

import dagger.Component
import dagger.Module
import ru.zavanton.unicorn.core.di.CoreApi
import javax.inject.Scope

@Scope
@Retention
annotation class PostScope

@PostScope
@Component(
    modules = [
        PostModule::class
    ],
    dependencies = [
        CoreApi::class
    ]
)
interface PostComponent {

    // Subcomponents
    fun plusPostActivityComponent(): PostActivityComponent
}

@Module
class PostModule






