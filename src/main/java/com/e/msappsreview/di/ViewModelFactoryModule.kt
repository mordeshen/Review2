package com.e.msappsreview.di

import androidx.lifecycle.ViewModelProvider
import com.e.msappsreview.viewmodelProvider.ViewModelProviderFactory
import dagger.Binds
import dagger.Module

@Module
abstract class ViewModelFactoryModule {
    @Binds
    abstract fun BindViewModelFactory(factory: ViewModelProviderFactory): ViewModelProvider.Factory
}