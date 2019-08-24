package ru.zavanton.unicorn.posts.di.component

import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import dagger.Subcomponent
import ru.zavanton.unicorn.posts.ui.activity.PostActivity
import ru.zavanton.unicorn.posts.ui.activity.viewModel.IPostActivityViewModel
import ru.zavanton.unicorn.posts.ui.activity.viewModel.PostActivityViewModel
import ru.zavanton.unicorn.posts.ui.activity.viewModel.PostActivityViewModelProviderFactory
import javax.inject.Qualifier
import javax.inject.Scope

@Scope
@Retention
annotation class PostActivityScope

@Qualifier
@Retention
annotation class PostActivityViewModelProviderFactoryQualifier

@PostActivityScope
@Subcomponent(
    modules = [
        BindsPostActivityModule::class
    ]
)
interface PostActivityComponent {

    // Subcomponents
    fun plusPostFragmentComponent(): PostFragmentComponent

    fun inject(postActivity: PostActivity)
}

@Module
interface BindsPostActivityModule {

    @Binds
    fun provideViewModel(impl: PostActivityViewModel): IPostActivityViewModel

    @Binds
    @PostActivityViewModelProviderFactoryQualifier
    fun provideViewModelProviderFactory(impl: PostActivityViewModelProviderFactory): ViewModelProvider.Factory
}
