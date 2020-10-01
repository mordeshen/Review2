package com.e.msappsreview.di.main

import androidx.lifecycle.ViewModel
import com.e.msappsreview.di.ViewModelKey
import com.e.msappsreview.ui.main.viewModel.MainViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class MainViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    abstract fun bindMainViewModel(mainViewModel: MainViewModel): ViewModel
}