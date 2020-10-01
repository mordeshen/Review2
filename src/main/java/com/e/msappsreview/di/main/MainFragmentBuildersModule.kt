package com.e.msappsreview.di.main

import com.e.msappsreview.ui.main.ItemFragment
import com.e.msappsreview.ui.main.ListFragment
import com.e.msappsreview.ui.main.ScanQrFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class MainFragmentBuildersModule {
    @ContributesAndroidInjector()
    abstract fun contributeListFragment(): ListFragment


    @ContributesAndroidInjector()
    abstract fun contributeItemFragment(): ItemFragment


    @ContributesAndroidInjector()
    abstract fun contributeScanQrFragment(): ScanQrFragment
}