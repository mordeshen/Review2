package com.e.msappsreview.di

import com.e.msappsreview.di.main.MainFragmentBuildersModule
import com.e.msappsreview.di.main.MainModule
import com.e.msappsreview.di.main.MainScope
import com.e.msappsreview.di.main.MainViewModelModule
import com.e.msappsreview.ui.main.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuildersModule {
    @MainScope
    @ContributesAndroidInjector(
        modules = [MainModule::class, MainFragmentBuildersModule::class, MainViewModelModule::class]
    )
    abstract fun contributeMainActivity(): MainActivity

}