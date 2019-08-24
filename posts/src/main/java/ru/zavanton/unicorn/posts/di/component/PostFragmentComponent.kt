package ru.zavanton.unicorn.posts.di.component

import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.Subcomponent
import retrofit2.Retrofit
import ru.zavanton.unicorn.posts.business.interactor.IPostInteractor
import ru.zavanton.unicorn.posts.business.interactor.PostInteractor
import ru.zavanton.unicorn.posts.data.repository.IPostRepository
import ru.zavanton.unicorn.posts.data.repository.PostRepository
import ru.zavanton.unicorn.posts.data.service.PostService
import ru.zavanton.unicorn.posts.ui.fragment.PostFragment
import ru.zavanton.unicorn.posts.ui.fragment.viewModel.IPostFragmentViewModel
import ru.zavanton.unicorn.posts.ui.fragment.viewModel.PostFragmentViewModel
import ru.zavanton.unicorn.posts.ui.fragment.viewModel.PostFragmentViewModelFactory
import javax.inject.Qualifier
import javax.inject.Scope

@Scope
@Retention
annotation class PostFragmentScope

@Qualifier
@Retention
annotation class PostFragmentViewModelFactoryQualifier

@PostFragmentScope
@Subcomponent(
    modules = [
        ProvidesPostFragmentModule::class,
        BindsPostFragmentModule::class
    ]
)
interface PostFragmentComponent {

    fun inject(fragment: PostFragment)
}

@Module
class ProvidesPostFragmentModule {

    @PostFragmentScope
    @Provides
    fun providePostService(retrofit: Retrofit): PostService = retrofit.create(PostService::class.java)
}

@Module
interface BindsPostFragmentModule {

    @Binds
    @PostFragmentViewModelFactoryQualifier
    fun provideViewModelProviderFactory(impl: PostFragmentViewModelFactory): ViewModelProvider.Factory

    @Binds
    fun providePostFragmentViewModel(impl: PostFragmentViewModel): IPostFragmentViewModel

    @Binds
    fun providePostInteractor(impl: PostInteractor): IPostInteractor

    @Binds
    fun providePostRepository(impl: PostRepository): IPostRepository
}
